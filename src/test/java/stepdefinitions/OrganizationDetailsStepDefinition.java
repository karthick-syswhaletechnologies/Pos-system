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

    @When("I click Admin")
    public void clickAdmin() {
        setup();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space()='Admin']")
        )).click();

        System.out.println("Admin Clicked");
    }

    @And("I click Organization Details")
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

    @Then("I click Add New")
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

    @And("I enter Organization Name {string}")
    public void enterOrganizationName(String organizationName) {
        setup();

        WebElement organizationNameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("org_name")
                )
        );

        organizationNameField.clear();
        organizationNameField.sendKeys(organizationName);

        System.out.println("Organization Name entered: " + organizationName);
    }

    @And("I enter Registration Number {string}")
    public void enterRegistrationNumber(String registrationNumber) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Registration No']")
        )).sendKeys(registrationNumber);

        System.out.println("Registration Number entered");
    }

    @And("I enter TIN Number {string}")
    public void enterTINNumber(String tinNumber) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='TIN No']")
        )).sendKeys(tinNumber);

        System.out.println("TIN Number entered");
    }

    @And("I enter Address {string}")
    public void enterAddress(String address) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Address']")
        )).sendKeys(address);

        System.out.println("Address entered");
    }

    @And("I enter Location {string}")
    public void enterLocation(String location) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Location']")
        )).sendKeys(location);

        System.out.println("Location entered");
    }

    @And("I enter Postcode {string}")
    public void enterPostcode(String postcode) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Postcode']")
        )).sendKeys(postcode);

        System.out.println("Postcode entered");
    }

    @And("I enter Contact Number {string}")
    public void enterContactNumber(String contactNumber) {
        setup();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Contact Number']")
        )).sendKeys(contactNumber);

        System.out.println("Contact Number entered");
    }

    @And("I click Organization Save button")
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