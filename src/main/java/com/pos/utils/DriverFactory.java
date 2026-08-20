package com.pos.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {

    private static WebDriver driver;

    private static Properties properties;


    // Load config.properties
    public static void loadProperties() {

        properties = new Properties();

        try (InputStream inputStream =
                     DriverFactory.class
                             .getClassLoader()
                             .getResourceAsStream("config/config.properties")) {

            if (inputStream == null) {

                throw new RuntimeException(
                        "config.properties file not found"
                );
            }

            properties.load(inputStream);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load config.properties", e
            );
        }
    }


    // Initialize browser
    public static void initializeDriver() {

        // Load properties
        loadProperties();

        String browser =
                properties.getProperty("browser");

        if (browser == null || browser.isEmpty()) {

            throw new RuntimeException(
                    "Browser is not specified in config.properties"
            );
        }

        browser = browser.toLowerCase();


        switch (browser) {

            case "chrome":

                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();

                break;


            case "firefox":

                WebDriverManager.firefoxdriver().setup();

                driver = new FirefoxDriver();

                break;


            case "edge":

                WebDriverManager.edgedriver().setup();

                driver = new EdgeDriver();

                break;


            case "safari":

                driver = new SafariDriver();

                break;


            default:

                throw new RuntimeException(
                        "Invalid browser: " + browser
                );
        }


        // Maximize browser
        driver.manage().window().maximize();
    }


    // Return driver
    public static WebDriver getDriver() {

        if (driver == null) {

            throw new RuntimeException(
                    "WebDriver is not initialized"
            );
        }

        return driver;
    }


    // Get URL
    public static String getUrl() {

        if (properties == null) {

            loadProperties();
        }

        return properties.getProperty("url");
    }


    // Quit browser
    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}