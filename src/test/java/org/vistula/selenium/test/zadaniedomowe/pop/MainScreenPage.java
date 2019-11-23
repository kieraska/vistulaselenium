package org.vistula.selenium.test.zadaniedomowe.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainScreenPage {

    private WebDriver driver;

    @FindBy(css = "a[href='http://demo.testarena.pl/administration']")
    private WebElement adminPanelLink;

    public MainScreenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAdminPanel() {
        adminPanelLink.click();
    }
}
