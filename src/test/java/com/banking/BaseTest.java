package com.banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

options.addArguments("--disable-notifications");

options.setExperimentalOption("prefs", java.util.Map.of(
        "credentials_enable_service", false,
        "profile.password_manager_enabled", false,
        "profile.password_manager_leak_detection", false
));

driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("http://localhost/Banking_Application_Testing_Project/banking-app/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}