package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseTest;

import static org.testng.Assert.assertEquals;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void initializePage() {
        driver.get("https://useinsider.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePageIsOpened() {
        // Insider ana sayfasının açıldığını doğrula
        assertEquals(homePage.getExpectedURL(), homePage.getCurrentURL(), "Insider home page is not opened.");
    }


}
