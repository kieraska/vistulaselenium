package org.vistula.selenium.test.zadaniedomowe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.vistula.selenium.test.zadaniedomowe.pop.LogInPage;
import org.vistula.selenium.test.zadaniedomowe.pop.MainScreenPage;
import org.vistula.selenium.test.zadaniedomowe.pop.ProjectsPage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class ArenaTestZadanieDomowe {

    private WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void logowanie(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.testarena.pl/zaloguj");

        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn();

        MainScreenPage mainScreenPage = new MainScreenPage(driver);
        mainScreenPage.openAdminPanel();

        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.addNewProject();

        WebElement projectNameInput = driver.findElement(By.id("name"));
        projectNameInput.click();
        String projectName = RandomStringUtils.randomAlphabetic(10, 20);
        projectNameInput.sendKeys(projectName);
        WebElement prefixInput = driver.findElement(By.id("prefix"));
        prefixInput.click();
        String prefixText = RandomStringUtils.randomAlphabetic(2, 5);
        String prefixNumber = randomNumeric(2, 5);
        String prefixTextAndNumber = prefixText + prefixNumber;
        prefixInput.sendKeys(prefixTextAndNumber);
        WebElement saveButton = driver.findElement(By.id("save"));
        saveButton.click();
        WebElement projectsLink = driver.findElement(By.cssSelector("a[href='http://demo.testarena.pl/administration/projects']"));
        projectsLink.click();
        WebElement newProject = driver.findElement(By.linkText(projectName));
        String foundProjectName = newProject.getText();
        Assertions.assertThat(foundProjectName).isEqualTo(projectName);
    }

}
