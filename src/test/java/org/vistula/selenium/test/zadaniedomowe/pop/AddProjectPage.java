package org.vistula.selenium.test.zadaniedomowe.pop;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class AddProjectPage {

    private WebDriver driver;

    @FindBy(id = "name")
    private WebElement projectNameInput;

    @FindBy(id = "prefix")
    private WebElement prefixInput;

    @FindBy(id = "save")
    private WebElement saveButton;

    public AddProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterProjectData() {
        String projectName = RandomStringUtils.randomAlphabetic(10, 20);
        projectNameInput.sendKeys(projectName);
        String prefixText = RandomStringUtils.randomAlphabetic(2, 5);
        String prefixNumber = randomNumeric(2, 5);
        String prefix = prefixText + prefixNumber;
        prefixInput.sendKeys(prefix);
        saveButton.click();
    }
}

