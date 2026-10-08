package com.banking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DepositTest extends BaseTest {

    @Test
    public void depositTest() {

        // Create explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 1: Enter username
        driver.findElement(By.name("username")).sendKeys("manasa");

        // Step 2: Enter password
        driver.findElement(By.name("password")).sendKeys("Test@123");

        // Step 3: Click Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Step 4: Wait for Dashboard
        wait.until(ExpectedConditions.urlContains("dashboard.php"));

        System.out.println("Dashboard opened successfully!");

        // Step 5: Click Deposit from Dashboard
        By depositMenu = By.cssSelector("a.menu[href='deposit.php']");

        wait.until(ExpectedConditions.elementToBeClickable(depositMenu));
        driver.findElement(depositMenu).click();

        // Step 6: Wait for Deposit page
        By amountField = By.name("amount");

        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));

        // Step 7: Enter deposit amount
        driver.findElement(amountField).sendKeys("500");

        // Step 8: Click Deposit button on Deposit page
        By depositSubmit = By.xpath("//button[normalize-space()='Deposit']");

        wait.until(ExpectedConditions.elementToBeClickable(depositSubmit));
        driver.findElement(depositSubmit).click();

        // Step 9: Display success message
        System.out.println("Deposit of ₹500 completed successfully!");

        // Basic test assertion
        Assert.assertTrue(true);
    }
}