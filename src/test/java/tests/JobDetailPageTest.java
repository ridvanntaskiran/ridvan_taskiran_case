package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JobDetailPage;
import utils.BaseTest;
import java.util.List;

public class JobDetailPageTest extends BaseTest {
    private JobDetailPage jobDetailPage;
    private SoftAssert softAssert;

    @BeforeClass
    public void setup() {
        jobDetailPage = new JobDetailPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void testJobListingsAndDetails() throws InterruptedException {
        driver.get("https://useinsider.com/careers/quality-assurance/");
        closeCookiesBanner();

        jobDetailPage.clickSeeAllQAJobs();
        jobDetailPage.filterByLocation();
        jobDetailPage.filterByDepartment();
        jobDetailPage.scrollToJobListings();
        jobDetailPage.waitForJobListingsToLoad();
        validateJobListings();
        validateJobDetails();
        validateViewRoleRedirection();


        softAssert.assertAll();
    }

    private void validateJobListings() {
        List<String> jobPositions = jobDetailPage.getJobPositions();
        List<String> jobDepartments = jobDetailPage.getJobDepartments();
        List<String> jobLocations = jobDetailPage.getJobLocations();

        softAssert.assertFalse(jobPositions.isEmpty(), "❌ Job positions list is empty!");
        softAssert.assertFalse(jobDepartments.isEmpty(), "❌ Job departments list is empty!");
        softAssert.assertFalse(jobLocations.isEmpty(), "❌ Job locations list is empty!");
    }

    private void validateJobDetails() {
        List<String> jobPositions = jobDetailPage.getJobPositions();
        List<String> jobDepartments = jobDetailPage.getJobDepartments();
        List<String> jobLocations = jobDetailPage.getJobLocations();

        for (int i = 0; i < jobPositions.size(); i++) {
            boolean isPositionValid = jobPositions.get(i).contains("Quality Assurance");
            boolean isDepartmentValid = jobDepartments.get(i).contains("Quality Assurance");
            boolean isLocationValid = jobLocations.get(i).contains("Istanbul, Turkey");

            if (!isPositionValid || !isDepartmentValid || !isLocationValid) {
                System.out.printf("⚠️ Job listing mismatch found: Position: %s, Department: %s, Location: %s%n",
                        jobPositions.get(i), jobDepartments.get(i), jobLocations.get(i));
            }

            softAssert.assertTrue(isPositionValid, "❌ Invalid Position: " + jobPositions.get(i));
            softAssert.assertTrue(isDepartmentValid, "❌ Invalid Department: " + jobDepartments.get(i));
            softAssert.assertTrue(isLocationValid, "❌ Invalid Location: " + jobLocations.get(i));
        }
    }

    private void validateViewRoleRedirection() {
        jobDetailPage.clickViewRoleButton();
        softAssert.assertTrue(jobDetailPage.isRedirectedToLeverPage(), "❌ Did not redirect to Lever Application form page!");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
