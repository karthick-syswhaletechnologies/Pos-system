package stepdefinitions;
import com.pos.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DropdownListPage;

public class DropdownListSteps {

    private WebDriver driver;
    private DropdownListPage dropdownPage;

    public DropdownListSteps() {

        driver = DriverFactory.getDriver();

        dropdownPage = new DropdownListPage(driver);
    }

    // ==========================================
    // BACKGROUND
    // ==========================================

    @Given("I open the Dropdown List page")
    public void i_open_the_dropdown_list_page() {

        dropdownPage.openPage();
    }

    // ==========================================
    // FTC-001
    // ==========================================

    @When("I leave the Item Name field empty")
    public void i_leave_the_item_name_field_empty() {

        dropdownPage.clearItemName();
    }

    @When("I click the Save button")
    public void i_click_the_save_button() {

        dropdownPage.clickSave();
    }

    @Then("the Item required validation message should be displayed")
    public void item_required_validation_message_should_be_displayed() {

        Assert.assertTrue(
                "Item required validation message was not displayed",
                dropdownPage.isRequiredMessageDisplayed()
        );
    }

    // ==========================================
    // FTC-002
    // ==========================================

    @When("I enter an existing item name")
    public void i_enter_an_existing_item_name() {

        dropdownPage.enterItemName("Delivered");
    }

    @Then("the duplicate item validation message should be displayed")
    public void duplicate_item_validation_message_should_be_displayed() {

        Assert.assertTrue(
                "Duplicate validation message was not displayed",
                dropdownPage.isDuplicateMessageDisplayed()
        );
    }

    // ==========================================
    // FTC-003
    // ==========================================

    @When("I enter more than the allowed maximum characters in Item Name")
    public void i_enter_more_than_allowed_characters() {

        String longValue =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                        "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        dropdownPage.enterItemName(longValue);
    }

    @Then("the Item Name field should not accept more than the maximum allowed characters")
    public void item_name_should_not_accept_maximum_characters() {

        String value = dropdownPage.getItemName();

        Assert.assertTrue(
                "Item Name accepted excessive characters",
                value.length() <= 100
        );
    }

    // ==========================================
    // FTC-004
    // ==========================================

    @When("I click the Edit icon for a record")
    public void i_click_edit_icon() {

        dropdownPage.selectDropdownType();
        dropdownPage.clickEdit();
    }

    @When("I update the Item Name")
    public void i_update_item_name() {

        dropdownPage.enterItemName("Updated Item");
    }

    @Then("the record should be updated successfully")
    public void record_should_be_updated_successfully() {

        String body =
                driver.findElement(
                        org.openqa.selenium.By.tagName("body")
                ).getText().toLowerCase();

        Assert.assertTrue(
                "Record update was not successful",
                body.contains("updated")
                        || body.contains("success")
        );
    }

    // ==========================================
    // FTC-005
    // ==========================================

    @When("I click the Delete icon for a record")
    public void i_click_delete_icon() {

        dropdownPage.selectDropdownType();
        dropdownPage.clickDelete();
    }

    @When("I confirm the deletion")
    public void i_confirm_the_deletion() {

        dropdownPage.confirmDelete();
    }

    @Then("the record should be deleted successfully")
    public void record_should_be_deleted_successfully() {

        String body =
                driver.findElement(
                        org.openqa.selenium.By.tagName("body")
                ).getText().toLowerCase();

        Assert.assertTrue(
                "Record deletion was not successful",
                body.contains("deleted")
                        || body.contains("success")
        );
    }

    // ==========================================
    // FTC-006
    // ==========================================

    @Then("the delete confirmation popup should be displayed")
    public void delete_confirmation_popup_should_be_displayed() {

        Assert.assertTrue(
                "Delete confirmation popup was not displayed",
                dropdownPage.isDeleteConfirmationDisplayed()
        );
    }

    // ==========================================
    // FTC-007
    // ==========================================

    @When("I click the View icon for a record")
    public void i_click_view_icon() {

        dropdownPage.selectDropdownType();
        dropdownPage.clickView();
    }

    @Then("the record details should be displayed in read-only mode")
    public void record_details_should_be_read_only() {

        Assert.assertTrue(
                "Record is not displayed in read-only mode",
                dropdownPage.isReadOnly()
        );
    }

    // ==========================================
    // FTC-008
    // ==========================================

    @When("I enter values in the form")
    public void i_enter_values_in_form() {

        dropdownPage.selectDropdownType();
        dropdownPage.enterItemName("Test Item");
    }

    @When("I click the Reset button")
    public void i_click_reset_button() {

        dropdownPage.clickReset();
    }

    @Then("all entered values should be cleared")
    public void all_entered_values_should_be_cleared() {

        Assert.assertEquals(
                "Item field was not cleared",
                "",
                dropdownPage.getItemName()
        );
    }

    // ==========================================
    // FTC-009
    // ==========================================

    @Then("the available records should be displayed in the grid")
    public void records_should_be_displayed_in_grid() {

        int count = dropdownPage.getRecordCount();

        Assert.assertTrue(
                "No records were displayed in the grid",
                count > 0
        );
    }

    // ==========================================
    // FTC-010
    // ==========================================

    @When("I scroll to the bottom of the page")
    public void i_scroll_to_bottom() {

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "window.scrollTo(0, document.body.scrollHeight)"
                );
    }

    @Then("pagination should be displayed")
    public void pagination_should_be_displayed() {

        Assert.assertTrue(
                "Pagination is not displayed",
                dropdownPage.isPaginationDisplayed()
        );
    }

    // ==========================================
    // FTC-011
    // ==========================================

    @When("I click the Dropdown Type field")
    public void i_click_dropdown_type_field() {

        dropdownPage.clickDropdownType();
    }

    @When("I select a Dropdown Type value")
    public void i_select_dropdown_type_value() {

        dropdownPage.selectDropdownType();
    }

    @Then("the selected value should be displayed in the Dropdown Type field")
    public void selected_dropdown_value_should_be_displayed() {

        String value =
                dropdownPage.getSelectedDropdownType();

        Assert.assertNotNull(
                "Dropdown Type value was not selected",
                value
        );

        Assert.assertFalse(
                "Default Dropdown Type is still selected",
                value.contains("Select Type")
        );
    }

    // ==========================================
    // FTC-012
    // ==========================================

    @When("I click the Filter By field")
    public void i_click_filter_by_field() {

        dropdownPage.selectFilterBy();
    }

    @When("I select a Filter By value")
    public void i_select_filter_by_value() {

        dropdownPage.selectFilterBy();
    }

    @Then("the selected value should be displayed in the Filter By field")
    public void selected_filter_value_should_be_displayed() {

        String value =
                dropdownPage.getSelectedFilter();

        Assert.assertNotNull(
                "Filter By value was not selected",
                value
        );

        Assert.assertFalse(
                "Default Filter By value is still selected",
                value.contains("Select Filter")
        );
    }

    // ==========================================
    // FTC-013
    // ==========================================

    @When("I enter a valid item name")
    public void i_enter_valid_item_name() {

        dropdownPage.enterItemName("Delivered");
    }

    @Then("the Item Name field should accept the entered value")
    public void item_name_should_accept_value() {

        Assert.assertEquals(
                "Delivered",
                dropdownPage.getItemName()
        );
    }

    // ==========================================
    // FTC-014
    // ==========================================

    @Then("the Edit icon should be displayed for every record")
    public void edit_icon_should_be_displayed() {

        int records = dropdownPage.getRecordCount();
        int editButtons = dropdownPage.getEditButtonCount();

        Assert.assertEquals(
                "Edit icon count does not match record count",
                records,
                editButtons
        );
    }

    // ==========================================
    // FTC-015
    // ==========================================

    @Then("the View option should be displayed for every record")
    public void view_option_should_be_displayed() {

        int records = dropdownPage.getRecordCount();
        int viewButtons = dropdownPage.getViewButtonCount();

        Assert.assertEquals(
                "View option count does not match record count",
                records,
                viewButtons
        );
    }
}

