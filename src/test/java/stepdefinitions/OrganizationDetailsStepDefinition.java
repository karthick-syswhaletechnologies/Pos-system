package stepdefinitions;

import com.pos.utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrganizationDetailsStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    private void setup() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User clicks Admin")
    public void clickAdmin() {
        setup();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space()='Admin']")
        )).click();

        System.out.println("Admin Clicked");
    }

    @And("User clicks Organization Details")
    public void clickOrganizationDetails() {
        setup();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space()='Organization Details']")
        )).click();

        System.out.println("Organization Details Clicked");
    }

    @Then("Organization Details page should be displayed")
    public void organizationDetailsPageShouldBeDisplayed() {
        setup();

        wait.until(ExpectedConditions.urlContains("/OrganizationDetails"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[normalize-space()='Organization Details']")
        ));

        System.out.println("Organization Details page displayed successfully");
    }

    @And("Add New button should be displayed")
    public void addNewButtonShouldBeDisplayed() {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button.add-btnOrganization")
        ));

        System.out.println("Add New button displayed successfully");
    }

    @Then("User clicks Add New")
    public void clickAddNew() {
        setup();

        WebElement addNewButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("button.add-btnOrganization")
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                addNewButton
        );

        wait.until(ExpectedConditions.elementToBeClickable(addNewButton));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                addNewButton
        );

        System.out.println("Add New button clicked successfully");
    }

    @Then("Organization creation form should be displayed")
    public void organizationCreationFormShouldBeDisplayed() {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[normalize-space()='Organization Form']")
        ));

        System.out.println("Organization creation form displayed successfully");
    }

    @And("User enters Organization Name {string}")
    public void enterOrganizationName(String organizationName) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("org_name")
        )).sendKeys(organizationName);

        System.out.println("Organization Name entered");
    }

    @And("User enters Registration Number {string}")
    public void enterRegistrationNumber(String registrationNumber) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("registration_no")
        )).sendKeys(registrationNumber);

        System.out.println("Registration Number entered");
    }

    @And("User enters TIN Number {string}")
    public void enterTINNumber(String tinNumber) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("tin_no")
        )).sendKeys(tinNumber);

        System.out.println("TIN Number entered");
    }

    @And("User enters Address {string}")
    public void enterAddress(String address) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("address")
        )).sendKeys(address);

        System.out.println("Address entered");
    }

    @And("User enters Location {string}")
    public void enterLocation(String location) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("location")
        )).sendKeys(location);

        System.out.println("Location entered");
    }

    @And("User selects Country {string}")
    public void selectCountry(String country) {

        setup();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'app-custom-dropdown-selected') and contains(.,'Select Country')]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[normalize-space()='" + country + "']")
        )).click();

        System.out.println("Country selected: " + country);
    }

    @And("User selects State {string}")
    public void selectState(String state) {
        setup();

        driver.findElement(By.xpath(
                "//div[contains(@class,'app-custom-dropdown-selected') and normalize-space()='Select State']"
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='" + state + "']")
        )).click();

        System.out.println("State selected: " + state);
    }

    @And("User selects District {string}")
    public void selectDistrict(String district) {
        setup();

        driver.findElement(By.xpath(
                "//div[contains(@class,'app-custom-dropdown-selected') and normalize-space()='Select District']"
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='" + district + "']")
        )).click();

        System.out.println("District selected: " + district);
    }

    @And("User enters Postcode {string}")
    public void enterPostcode(String postcode) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Postcode']")
        )).sendKeys(postcode);

        System.out.println("Postcode entered");
    }

    @And("User enters Contact Number {string}")
    public void enterContactNumber(String contactNumber) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Contact Number']")
        )).sendKeys(contactNumber);

        System.out.println("Contact Number entered");
    }

    @And("User clicks Organization Save button")
    public void clickOrganizationSaveButton() {
        setup();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Save']")
        )).click();

        System.out.println("Organization Save button clicked");
    }

    @And("Search by Org Name field should be displayed")
    public void searchByOrgNameFieldShouldBeDisplayed() {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Search by Org Name']")
        ));

        System.out.println("Search by Org Name field displayed successfully");
    }
}