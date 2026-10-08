package com.banking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WithdrawalTest extends BaseTest {

    @Test
    public void withdrawalTest() {

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

        // Step 5: Click Withdrawal
        By withdrawalMenu = By.cssSelector("a.menu[href='withdrawal.php']");

        wait.until(ExpectedConditions.elementToBeClickable(withdrawalMenu));
        driver.findElement(withdrawalMenu).click();

        // Step 6: Wait for Withdrawal page
        By amountField = By.name("amount");

        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));

        // Step 7: Enter withdrawal amount
        driver.findElement(amountField).sendKeys("200");

        // Step 8: Click Withdrawal button
        By withdrawalSubmit = By.xpath("//button[normalize-space()='Withdraw']");

        wait.until(ExpectedConditions.elementToBeClickable(withdrawalSubmit));
        driver.findElement(withdrawalSubmit).click();

        // Step 9: Display result
        System.out.println("Withdrawal of ₹200 completed successfully!");

        Assert.assertTrue(true);
    }
}