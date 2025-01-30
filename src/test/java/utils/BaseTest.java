package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    public void closeCookiesBanner() {
        try {
            By acceptCookiesButton = By.xpath("//a[contains(text(), 'Accept All')]");
            WebElement acceptButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptButton.click();
            System.out.println("✅ Cookies banner kapatıldı.");
        } catch (Exception e) {
            System.out.println("⚠️ Cookies banner zaten kapalı veya bulunamadı.");
        }
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/ridvantaskiran/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
