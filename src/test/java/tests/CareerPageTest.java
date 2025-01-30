package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CareerPage;
import utils.BaseTest;

import static org.testng.Assert.assertTrue;


public class CareerPageTest extends BaseTest {

    private CareerPage careerPage;
    private SoftAssert softAssert;



    @BeforeClass
    public void setup() {
        careerPage = new CareerPage(driver);
        softAssert = new SoftAssert(); // SoftAssert başlatılıyor

    }

    @Test
    public void testNavigateToCareersPage() {
        driver.get("https://useinsider.com/");
        careerPage.navigateToCareersPage();

        // Sayfanın doğru açıldığını doğrula
        softAssert.assertTrue(driver.getCurrentUrl().contains("/careers/"), "Career page did not open!");
    }

    @Test(dependsOnMethods = "testNavigateToCareersPage")
    public void testCareerPageBlocksAreVisible() {
        System.out.println("Checking career page blocks...");

        // SoftAssert kullanarak her bloğu ayrı ayrı doğrula
        softAssert.assertTrue(careerPage.isLocationBlockDisplayed(), "⚠️ Locations block is not visible!");
        softAssert.assertTrue(careerPage.isTeamsBlockDisplayed(), "⚠️ Teams block is not visible!");
        softAssert.assertTrue(careerPage.isLifeAtInsiderBlockDisplayed(), "⚠️ Life at Insider block is not visible!");

        // Tüm hataları test sonunda raporla
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
