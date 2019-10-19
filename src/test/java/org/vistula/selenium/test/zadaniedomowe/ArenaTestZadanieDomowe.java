package org.vistula.selenium.test.zadaniedomowe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebElement login = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement buttonZaloguj = driver.findElement(By.id("login"));
        login.click();
        login.sendKeys("administrator@testarena.pl");
        password.sendKeys("sumXQQ72$L");
        buttonZaloguj.click();
        WebElement adminPanel = driver.findElement(By.cssSelector("a[href='http://demo.testarena.pl/administration']"));
        adminPanel.click();
        WebElement addProject = driver.findElement(By.cssSelector("a[href='http://demo.testarena.pl/administration/add_project']"));
        addProject.click();
        WebElement projectName = driver.findElement(By.id("name"));
        projectName.click();
        String name = RandomStringUtils.randomAlphabetic(10, 20);
        projectName.sendKeys(name);
        WebElement prefix = driver.findElement(By.id("prefix"));
        prefix.click();
        String prefixText = RandomStringUtils.randomAlphabetic(2, 5);
        String prefixNumber = randomNumeric(2, 5);
        String prefixTextAndNumber = prefixText + prefixNumber;
        prefix.sendKeys(prefixTextAndNumber);
        WebElement saveButton = driver.findElement(By.id("save"));
        saveButton.click();
    }

}
