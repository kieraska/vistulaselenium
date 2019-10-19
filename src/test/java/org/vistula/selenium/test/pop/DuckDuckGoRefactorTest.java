package org.vistula.selenium.test.pop;

import org.junit.Test;

public class DuckDuckGoRefactorTest extends VistulaSeleniumTest {


    @Test
    public void szukajVistulaDuck(){

        HomePage homePage = new HomePage(driver);
        homePage.search("Vistula University");


        SearchResultPage searchResultPage = new SearchResultPage(driver);

        searchResultPage.waitForSidebarLink();
        searchResultPage.verifyLinkUrl("https://www.vistula.edu.pl/");
    }

}
