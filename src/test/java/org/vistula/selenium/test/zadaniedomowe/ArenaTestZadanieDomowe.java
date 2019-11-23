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
import org.vistula.selenium.test.zadaniedomowe.pop.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class ArenaTestZadanieDomowe extends BaseTest{

    @Test
    public void addNewProjectTest(){
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIn();

        MainScreenPage mainScreenPage = new MainScreenPage(driver);
        mainScreenPage.openAdminPanel();

        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.addNewProject();

        AddProjectPage addProjectPage = new AddProjectPage(driver);
        String projectName = RandomStringUtils.randomAlphabetic(10, 20);
        addProjectPage.enterProjectData(projectName);

        ProjectViewPage projectViewPage = new ProjectViewPage(driver);
        projectViewPage.openProjectList();

        projectsPage.findAddedProject(projectName);
    }

}
