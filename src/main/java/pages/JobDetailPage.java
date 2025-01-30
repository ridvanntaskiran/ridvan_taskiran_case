package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class JobDetailPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private Locators locators;

    public JobDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.locators = new Locators();
    }

    public void clickSeeAllQAJobs() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.SEE_ALL_QA_JOBS_BUTTON)).click();
    }

    public void filterByLocation() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.LOCATION_DROPDOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locators.ISTANBUL_OPTION)).click();
    }

    public void filterByDepartment() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.DEPARTMENT_DROPDOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locators.QA_DEPARTMENT_OPTION)).click();
    }

    public List<String> getJobPositions() {
        return driver.findElements(locators.JOB_TITLES).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getJobDepartments() {
        return driver.findElements(locators.JOB_DEPARTMENTS).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getJobLocations() {
        return driver.findElements(locators.JOB_LOCATIONS).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void scrollToJobListings() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement browseOpenPositions = driver.findElement(By.xpath("(//h3[contains(text(),'Browse')])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", browseOpenPositions);
    }

    public void waitForJobListingsToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".position-list-item"))
        );
    }

    public void clickViewRoleButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement firstJobCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".position-list-item")));
        actions.moveToElement(firstJobCard).pause(Duration.ofSeconds(5)).perform();
        WebElement viewRoleButton = wait.until(ExpectedConditions.elementToBeClickable(
                firstJobCard.findElement(By.xpath(".//a[contains(@class, 'btn-navy') and contains(text(), 'View Role')]"))
        ));

        viewRoleButton.click();
    }

    public boolean isRedirectedToLeverPage() {
        String mainWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isCorrectUrl = wait.until(ExpectedConditions.urlContains("lever.co"));
        driver.close();
        driver.switchTo().window(mainWindow);

        return isCorrectUrl;
    }
}




