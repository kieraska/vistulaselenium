package org.vistula.selenium.test.pop;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSidebarLink() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("module__official-url")));
        // .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.module__official-url")));

    }

    public void verifyLinkUrl(String url) {
        WebElement link = driver.findElement(By.cssSelector("a.module__official-url"));
        Assertions.assertThat(link.getAttribute("href")).isEqualTo(url);
    }
}
