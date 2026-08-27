package com.pos.utils;

import org.openqa.selenium.WebDriver; import org.openqa.selenium.chrome.ChromeDriver; import org.openqa.selenium.edge.EdgeDriver; import org.openqa.selenium.firefox.FirefoxDriver; import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException; import java.io.InputStream; import java.util.Properties;

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

        loadProperties();

        String browser = properties.getProperty("browser");

        if (browser == null || browser.trim().isEmpty()) {
            throw new RuntimeException(
                    "Browser is not specified in config.properties"
            );
        }

        browser = browser.trim().toLowerCase();

        switch (browser) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
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

