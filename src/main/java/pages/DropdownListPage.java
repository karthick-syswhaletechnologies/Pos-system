package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DropdownListPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public DropdownListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // =========================
    // LOCATORS
    // =========================

    private By dropdownType =
            By.xpath("//label[contains(normalize-space(),'Dropdown Type')]/following::select[1]");

    private By filterBy =
            By.xpath("//label[contains(normalize-space(),'Filter By')]/following::select[1]");

    private By itemName =
            By.xpath("//label[contains(normalize-space(),'Item Name')]/following::input[1]");

    private By saveButton =
            By.xpath("//button[normalize-space()='Save']");

    private By resetButton =
            By.xpath("//button[normalize-space()='Reset']");

    private By editButtons =
            By.xpath("//button[contains(@class,'edit') or contains(@aria-label,'Edit') or .//*[contains(@class,'edit')]]");

    private By deleteButtons =
            By.xpath("//button[contains(@class,'delete') or contains(@aria-label,'Delete') or .//*[contains(@class,'delete')]]");

    private By viewButtons =
            By.xpath("//button[contains(@class,'view') or contains(@aria-label,'View') or .//*[contains(@class,'view')]]");

    private By pagination =
            By.xpath("//*[contains(@class,'pagination')]");

    // =========================
    // PAGE ACTIONS
    // =========================

    public void openPage() {

        driver.get("http://localhost:3000/Dashboard/Dropdownlist");

        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownType));
    }

    public void clickDropdownType() {

        wait.until(ExpectedConditions.elementToBeClickable(dropdownType))
                .click();
    }

    public void selectDropdownType() {

        WebElement dropdown =
                wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownType));

        List<WebElement> options =
                dropdown.findElements(By.tagName("option"));

        for (WebElement option : options) {

            String text = option.getText().trim();

            if (!text.isEmpty()
                    && !text.equalsIgnoreCase("-- Select Type --")) {

                option.click();
                return;
            }
        }

        throw new RuntimeException("No Dropdown Type option available");
    }

    public String getSelectedDropdownType() {

        WebElement dropdown =
                wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownType));

        return dropdown.findElement(
                By.xpath("./option[@selected]")
        ).getText();
    }

    public void selectFilterBy() {

        WebElement dropdown =
                wait.until(ExpectedConditions.visibilityOfElementLocated(filterBy));

        List<WebElement> options =
                dropdown.findElements(By.tagName("option"));

        for (WebElement option : options) {

            String text = option.getText().trim();

            if (!text.isEmpty()
                    && !text.equalsIgnoreCase("-- Select Filter --")) {

                option.click();
                return;
            }
        }

        throw new RuntimeException("No Filter By option available");
    }

    public String getSelectedFilter() {

        WebElement dropdown =
                wait.until(ExpectedConditions.visibilityOfElementLocated(filterBy));

        return dropdown.findElement(
                By.xpath("./option[@selected]")
        ).getText();
    }

    public void enterItemName(String value) {

        WebElement field =
                wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));

        field.clear();
        field.sendKeys(value);
    }

    public void clearItemName() {

        WebElement field =
                wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));

        field.clear();
    }

    public String getItemName() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(itemName)
        ).getAttribute("value");
    }

    public void clickSave() {

        wait.until(ExpectedConditions.elementToBeClickable(saveButton))
                .click();
    }

    public void clickReset() {

        wait.until(ExpectedConditions.elementToBeClickable(resetButton))
                .click();
    }

    // =========================
    // RECORD ACTIONS
    // =========================

    public void clickEdit() {

        wait.until(ExpectedConditions.elementToBeClickable(editButtons))
                .click();
    }

    public void clickDelete() {

        wait.until(ExpectedConditions.elementToBeClickable(deleteButtons))
                .click();
    }

    public void clickView() {

        wait.until(ExpectedConditions.elementToBeClickable(viewButtons))
                .click();
    }

    public int getEditButtonCount() {

        return driver.findElements(editButtons).size();
    }

    public int getViewButtonCount() {

        return driver.findElements(viewButtons).size();
    }

    public int getRecordCount() {

        By rows = By.xpath(
                "//table//tbody/tr"
        );

        return driver.findElements(rows).size();
    }

    public boolean isPaginationDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(pagination)
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================
    // VALIDATION
    // =========================

    public boolean isRequiredMessageDisplayed() {

        String pageText = driver.findElement(By.tagName("body"))
                .getText()
                .toLowerCase();

        return pageText.contains("item is required")
                || pageText.contains("item required")
                || pageText.contains("required");
    }

    public boolean isDuplicateMessageDisplayed() {

        String pageText = driver.findElement(By.tagName("body"))
                .getText()
                .toLowerCase();

        return pageText.contains("item already exists")
                || pageText.contains("already exists")
                || pageText.contains("duplicate");
    }

    public boolean isDeleteConfirmationDisplayed() {

        try {

            By confirmation = By.xpath(
                    "//*[contains(text(),'Are you sure') " +
                            "or contains(text(),'Confirm') " +
                            "or contains(text(),'confirmation')]"
            );

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(confirmation)
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public void confirmDelete() {

        By confirmButton = By.xpath(
                "//button[normalize-space()='Confirm' " +
                        "or normalize-space()='Yes' " +
                        "or normalize-space()='Delete']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(confirmButton)
        ).click();
    }

    public boolean isReadOnly() {

        try {

            WebElement field =
                    driver.findElement(itemName);

            return !field.isEnabled();

        } catch (Exception e) {

            return false;
        }
    }
}
