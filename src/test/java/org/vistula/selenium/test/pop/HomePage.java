package org.vistula.selenium.test.pop;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(id = "search_form_input_homepage")
    private WebElement poleSzukania;

    @FindBy(id = "search_button_homepage")
    private WebElement lupka;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //initElements();
    }


    public void search(String text) {
        poleSzukania.click();
        poleSzukania.sendKeys(text);
        poleSzukania.sendKeys(Keys.ENTER);
    }

   // private void initElements() {
     //   poleSzukania = driver.findElement(By.id("search_form_input_homepage"));
       // lupka = driver.findElement(By.id("search_button_homepage"));
 //   }
}
