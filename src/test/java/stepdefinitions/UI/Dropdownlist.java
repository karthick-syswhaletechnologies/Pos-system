package stepdefinitions.UI;

import com.pos.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Dropdownlist {

    WebDriver driver = DriverFactory.getDriver();


    @FindBy(xpath="//input[@placeholder='Password']")
    public WebElement password;

    @FindBy(xpath="//button[normalize-space()='Login']")
    public WebElement LoginBtn;
    @FindBy(xpath="//input[@placeholder='User Id']")
    public WebElement userID;


    public Dropdownlist getDropdownList(){
        return PageFactory.initElements(driver, Dropdownlist.class);
    }

    public void navigate_to_dashboard() throws InterruptedException {


// Browser Launch
        String url = DriverFactory.getUrl();

        driver.get(url);

        System.out.println("Browser launched successfully");
        System.out.println("URL opened: " + url);


// Loginpage

//BranchCode
        WebElement branchCode = driver.findElement
                (By.xpath("//input[@placeholder='Branch Code']"));
        branchCode.sendKeys("SA001", Keys.ENTER);

        Thread.sleep(1000);
//UserID

        userID.sendKeys("superadmin");
//Password

        password.sendKeys("Admin@123");

//Login Button


        LoginBtn.click();


//Navigate to Landing Page

        Thread.sleep(1000);

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

        WebElement okBtn = driver.findElement(By.xpath("//button[text()='OK']"));
        okBtn.click();



    }

    public void verify_the_dropdown_list_page() {

        //User able to see the DashBoard
// Select staff & User

        WebElement staffanduserBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/ul/li[2]/span"));
        staffanduserBtn.click();
//


// Select the Dropdown list


        WebElement dropdownItem = driver.findElement(By.xpath("//ul[@class='submenu']//li[text()='Dropdownlist']"));
        dropdownItem.click();
// throw new io.cucumber.java.PendingException();
    }

    public void enter_fields() {

// driver.findElement()


// Organization
        WebElement organization = driver.findElement(
                By.xpath("//select[@name='organization_id']"));
        organization.click();

        // Create Select object
        Select select = new Select(organization);

        // Select POS System Organization
        select.selectByVisibleText("POS System Organization");

        // Select Branch Code

        WebElement branchCode = driver.findElement(By.xpath("//input[@name='branch_code']"));
        branchCode.sendKeys("SA001");

        // Select the BranchName

        WebElement branchName = driver.findElement(By.xpath("//input[@name='branch_name']"));
        branchName.sendKeys("POS-SYSTEM");


// Service Type
        WebElement serviceType = driver.findElement(By.xpath("//input[@name='service_type']"));
        serviceType.sendKeys("123456");
    }

//

    @Then("Save Dropdown list")
    public void save_dropdown_list() {

// save the Details
// WebElement saveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
// saveBtn.click();

//

    }

    @Given("Login to App and Navigate to Dashboard")
    public void login_to_app_and_navigate_to_dashboard() throws InterruptedException {
        getDropdownList().navigate_to_dashboard();
    }
    @When("user is on dashboard verify the dropdown list page")
    public void user_is_on_dashboard_verify_the_dropdown_list_page() {
        getDropdownList().verify_the_dropdown_list_page();
    }
    @Then("Enter Fields Dropdown type,Filter by and Item Name")
    public void enter_fields_dropdown_type_filter_by_and_item_name() {
        getDropdownList().enter_fields();
    }
}