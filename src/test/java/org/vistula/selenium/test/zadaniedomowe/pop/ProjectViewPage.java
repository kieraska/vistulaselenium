package org.vistula.selenium.test.zadaniedomowe.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectViewPage {

    private WebDriver driver;

    @FindBy(css = "a[href='http://demo.testarena.pl/administration/projects']")
    private WebElement projectsLink;

    public ProjectViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openProjectList() {
        projectsLink.click();
    }
}
