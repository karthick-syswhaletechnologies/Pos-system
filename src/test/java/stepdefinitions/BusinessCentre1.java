package stepdefinitions;

import com.pos.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusinessCentre1 {

    WebDriver driver = DriverFactory.getDriver();


    @Given("Login to App and Navigate to Dashboard")
    public void login_to_app_and_navigate_to_dashboard() throws InterruptedException {


//        Browser Launch
        String url = DriverFactory.getUrl();

        DriverFactory.getDriver().get(url);

        System.out.println("Browser launched successfully");
        System.out.println("URL opened: " + url);


//        Loginpage

//BranchCode
        WebElement branchCode =  driver.findElement
                (By.xpath("//input[@placeholder='Branch Code']"));
        branchCode.sendKeys("SA001", Keys.ENTER);

        Thread.sleep(1000);
//UserID
        WebElement userID = driver.findElement
                (By.xpath("//input[@placeholder='User Id']"));
        userID.sendKeys("superadmin");
//Password
        WebElement password = driver.findElement
                (By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Admin@123");

//Login Button

        WebElement LoginBtn = driver.findElement
                (By.xpath("//button[normalize-space()='Login']"));
        LoginBtn.click();


//Navigate to Landing Page

        Thread.sleep(3000);

        WebElement GetStartBtn = driver.findElement
                (By.xpath("//button[normalize-space()='Get Started']"));
        GetStartBtn.click();

//Select the Branch


        // 1. Click the Branch dropdown
        WebElement branchDropdown = driver.findElement(
                By.xpath("//div[contains(@class,'custom-dropdown-selected')]")
        );

        branchDropdown.click();

// 2. Select Main Branch
        WebElement mainBranch = driver.findElement(
                By.xpath("//div[contains(@class,'custom-dropdown-options')]//div[@class='custom-dropdown-option' and normalize-space()='Main Branch']")
        );

        mainBranch.click();


    }



    @When("User is on dashboard verify the Business Center  list page")
    public void user_is_on_dashboard_verify_the_business_center_list_page() {
        WebElement AdminBtn = driver.findElement(By.xpath("//span[text()='Admin']"));
        AdminBtn.click();
    }


    @Then("Enter the Business Centre Fields")
    public void enter_the_business_centre_fields() {

    }


    @Then("Enter the Branch Information,Address and Contact Number")
    public void enter_the_branch_information_address_and_contact_number() {

    }


    @Then("Save Business Centre List")
    public void save_business_centre_list() {


    }
}
