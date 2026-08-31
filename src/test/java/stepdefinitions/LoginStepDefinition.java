package stepdefinitions;

import com.pos.utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    private void setup() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User opens the POS System login page")
    public void openLoginPage() {

        setup();

        driver.get(DriverFactory.getUrl());

        System.out.println("Login page opened");
    }

    @And("User enters Branch Code {string}")
    public void enterBranchCode(String branchCode) {

        setup();

        driver.findElement(
                By.xpath("//input[@placeholder='Branch Code']")
        ).clear();

        driver.findElement(
                By.xpath("//input[@placeholder='Branch Code']")
        ).sendKeys(branchCode);

        System.out.println("Branch Code entered");
    }

    @And("User enters User Id {string}")
    public void enterUserId(String userId) {

        setup();

        driver.findElement(
                By.xpath("//input[@placeholder='User Id']")
        ).clear();

        driver.findElement(
                By.xpath("//input[@placeholder='User Id']")
        ).sendKeys(userId);

        System.out.println("User Id entered");
    }

    @And("User enters Password {string}")
    public void enterPassword(String password) {

        setup();

        driver.findElement(
                By.xpath("//input[@placeholder='Password']")
        ).clear();

        driver.findElement(
                By.xpath("//input[@placeholder='Password']")
        ).sendKeys(password);

        System.out.println("Password entered");
    }

    @And("User clicks the Login button")
    public void clickLoginButton() {

        setup();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Login']")
                )
        ).click();

        System.out.println("Login button clicked");
    }

    @And("User clicks Get Started")
    public void clickGetStarted() {

        setup();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Get Started']")
                )
        ).click();

        System.out.println("Get Started clicked");
    }

    @And("User clicks the branch dropdown")
    public void clickBranchDropdown() {

        setup();

        By branchDropdown = By.cssSelector(
                "div.custom-dropdown-selected"
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(branchDropdown)
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(branchDropdown)
        ).click();

        System.out.println("Select Branch clicked successfully");
    }

    @And("User selects Super Admin Branch")
    public void selectSuperAdminBranch() {

        setup();

        By superAdminBranch = By.xpath(
                "//*[contains(@class,'custom-dropdown-option') and normalize-space()='Super Admin Branch']"
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(superAdminBranch)
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(superAdminBranch)
        ).click();

        System.out.println("Super Admin Branch selected successfully");
    }

    @And("User clicks OK")
    public void clickOK() {

        setup();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='OK' and not(@disabled)]"
                        )
                )
        ).click();

        System.out.println("OK button clicked");
    }

    @Then("Dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {

        setup();

        wait.until(
                ExpectedConditions.not(
                        ExpectedConditions.urlContains("/LandingPage")
                )
        );

        System.out.println("Dashboard opened");
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }
}