package stepdefinitions;

import api.BusinessCentreTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import static com.pos.utils.DriverFactory.driver;
public class BusniessCenter {

    BusinessCentreTest bc = new BusinessCentreTest();


    WebDriver driver;


    @When("User is on dashboard verify the Business Center  list page")
    public void user_is_on_dashboard_verify_the_business_center_list_page() {

//        Business Center01


        WebElement adminBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/ul/li[3]"));
        adminBtn.click();

        WebElement bcBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/ul/ul[2]/li[2]"));
        bcBtn.click();

        WebElement adnewBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/button"));
        adnewBtn.click();



    }
    @Then("Enter the Business Centre Fields")
    public void enter_the_business_centre_fields() {


//        Organization
        WebElement organization = driver.findElement(By.xpath("//select[@name='organization_id']"));
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


//        Service Type
        WebElement serviceType = driver.findElement(By.xpath("//input[@name='service_type']"));
        serviceType.sendKeys("123456");

        Allure.step("enter_the_business_centre_fields entre successfully", Status.PASSED);

    }
    @Then("Enter the Branch Information,Address and Contact Number")
    public void enter_the_branch_information_address_and_contact_number() {




    }

}
