package com.banking;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        // Enter username
        driver.findElement(By.name("username")).sendKeys("manasa");

        // Enter password
        driver.findElement(By.name("password")).sendKeys("Test@123");

        // Click Login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Check that login was successful
        Assert.assertFalse(driver.getCurrentUrl().contains("index.php"),
                "Login failed!");
        
        System.out.println("Login successful!");
    }
}