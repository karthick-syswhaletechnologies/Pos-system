package stepdefinitions;

import com.pos.utils.DriverFactory;
import io.cucumber.java.en.Given;

public class BrowserSteps {

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        String url = DriverFactory.getUrl();
        DriverFactory.getDriver().get(url);

        System.out.println("Browser launched successfully");
        System.out.println("URL opened: " + url);
    }

    @Given("I launch the chromeBrowser")
    public void i_launch_the_chrome_browser() throws InterruptedException {
        String url = DriverFactory.getUrl();
        DriverFactory.getDriver().get(url);

        Thread.sleep(5000);
    }
}