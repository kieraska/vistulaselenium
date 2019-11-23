package org.vistula.selenium.test.zadaniedomowe.pop;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {

    private WebDriver driver;

    @FindBy(css = "a[href='http://demo.testarena.pl/administration/add_project']")
    private WebElement addProject;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewProject() {
        addProject.click();
    }

    public void findAddedProject(String projectName) {
        WebElement newProject = driver.findElement(By.linkText(projectName));
        String foundProjectName = newProject.getText();
        Assertions.assertThat(foundProjectName).isEqualTo(projectName);
    }
}
