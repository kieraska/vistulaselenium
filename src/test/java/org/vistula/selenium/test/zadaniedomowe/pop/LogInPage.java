package org.vistula.selenium.test.zadaniedomowe.pop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement buttonZaloguj;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logIn() {
        login.click();
        login.sendKeys("administrator@testarena.pl");
        password.sendKeys("sumXQQ72$L");
        buttonZaloguj.click();
    }


}

