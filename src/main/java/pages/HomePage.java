package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getExpectedURL() {
        return "https://useinsider.com/";
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
