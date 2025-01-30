package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareerPage {
    WebDriver driver;
    private WebDriverWait wait;
    private Locators locators;

    public CareerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.locators = new Locators();
    }

    public void navigateToCareersPage() {
        driver.findElement(locators.COMPANY_DROPDOWN_BUTTON).click();
        wait.until(ExpectedConditions.elementToBeClickable(locators.CAREER_BUTTON)).click();
    }

    public boolean isLocationBlockDisplayed() {
        return isElementVisible(locators.LOCATIONS_BLOCK);
    }

    public boolean isTeamsBlockDisplayed() {
        return isElementVisible(locators.TEAMS_BLOCK);
    }

    public boolean isLifeAtInsiderBlockDisplayed() {
        return isElementVisible(locators.LIFE_AT_INSIDER_BLOCK);
    }

    private boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}