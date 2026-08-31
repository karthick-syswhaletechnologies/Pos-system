package hooks;

import com.pos.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    @Before
    public void setUp(Scenario scenario) {

        if (scenario.getSourceTagNames().contains("@API")) {
            return;
        }

        System.out.println("===== Starting Browser =====");

        DriverFactory.initializeDriver();
    }



    @After
    public void tearDown() {

        System.out.println("===== Closing Browser =====");

        //DriverFactory.quitDriver();
    }
}