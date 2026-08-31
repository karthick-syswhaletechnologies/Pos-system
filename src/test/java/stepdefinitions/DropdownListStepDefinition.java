package stepdefinitions;

import com.pos.utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownListStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    private void setup() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User clicks Staff and User")
    public void clickStaffAndUser() {

        setup();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[normalize-space()='Staff & User']")
                )
        ).click();
    }

    @And("User clicks Dropdownlist")
    public void clickDropdownlist() {

        setup();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[normalize-space()='Dropdownlist']")
                )
        ).click();
    }

    @And("User selects {string} from Dropdown Type")
    public void selectDropdownType(String type) {

        setup();

        Select dropdownType = new Select(
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//select[option[normalize-space()='state'] and option[normalize-space()='country'] and option[normalize-space()='district']]"
                                )
                        )
                )
        );

        dropdownType.selectByVisibleText(type);

        System.out.println("Dropdown Type selected: " + type);
    }

    @And("User selects {string} from Filter By")
    public void selectFilterBy(String filter) {

        setup();

        Select filterBy = new Select(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(
                                        "//label[normalize-space()='Filter By']/following-sibling::select"
                                )
                        )
                )
        );

        filterBy.selectByVisibleText(filter);
    }

    @And("User enters {string} in Item Name")
    public void enterItemName(String itemName) {

        setup();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Enter Item Name']")
                )
        ).sendKeys(itemName);
    }

    @And("User clicks Save")
    public void clickSave() {

        setup();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Save']")
                )
        ).click();
    }

    @Then("the State dropdown value should be displayed")
    public void stateDropdownValueShouldBeDisplayed() {

        setup();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[normalize-space()='Tamil Nadu']")
                )
        );

        System.out.println("State dropdown value saved successfully");
    }
}