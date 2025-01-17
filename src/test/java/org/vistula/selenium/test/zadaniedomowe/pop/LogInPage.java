package org.vistula.selenium.test.zadaniedomowe.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logIn() {
        loginInput.click();
        loginInput.sendKeys("administrator@testarena.pl");
        passwordInput.sendKeys("sumXQQ72$L");
        loginButton.click();
    }


}

