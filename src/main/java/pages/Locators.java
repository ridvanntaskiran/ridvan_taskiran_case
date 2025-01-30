package pages;

import org.openqa.selenium.By;

public class Locators {

    public By COMPANY_DROPDOWN_BUTTON = By.xpath("(//a[normalize-space()='Company'])[1]");
    public By CAREER_BUTTON = By.xpath("(//a[normalize-space()='Careers'])[1]");
    public By LOCATIONS_BLOCK = By.xpath("//*[contains(text(), 'Locations')]");
    public By TEAMS_BLOCK = By.xpath("//*[contains(text(), 'Teams']");
    public By LIFE_AT_INSIDER_BLOCK = By.xpath("//*[contains(text(), 'Life at Insider')]");


    public By SEE_ALL_QA_JOBS_BUTTON = By.xpath("//*[contains(text(), 'See all QA jobs')]");
    public By LOCATION_DROPDOWN = By.xpath("//span[@id='select2-filter-by-location-container']");
    public By DEPARTMENT_DROPDOWN = By.xpath("(//span[@id='select2-filter-by-department-container'])[1]");
    public By ISTANBUL_OPTION = By.xpath("//li[@role='option' and text()='Istanbul, Turkey']");
    public By QA_DEPARTMENT_OPTION = By.xpath("//li[@role='option' and text()='Quality Assurance']");
    public By JOB_LOCATIONS = By.cssSelector(".position-list-item.istanbul-turkey");
    public By JOB_DEPARTMENTS = By.cssSelector(".position-list-item.qualityassurance");
    public By JOB_TITLES = By.cssSelector("p.position-title");
    public By VIEW_ROLE_BUTTON = By.xpath("//a[contains(@class, 'btn-navy') and contains(text(), 'View Role')]");

}
