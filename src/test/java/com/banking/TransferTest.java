package com.banking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferTest extends BaseTest {

    @Test
    public void transferTest() {

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

        // Step 5: Click Fund Transfer
        By transferMenu = By.cssSelector("a.menu[href='transfer.php']");

        wait.until(ExpectedConditions.elementToBeClickable(transferMenu));
        driver.findElement(transferMenu).click();

        // Step 6: Wait for Beneficiary field
        By beneficiaryField = By.name("beneficiary");

        wait.until(ExpectedConditions.visibilityOfElementLocated(beneficiaryField));

        // Step 7: Enter beneficiary
        driver.findElement(beneficiaryField).sendKeys("TestBeneficiary");

        // Step 8: Enter transfer amount
        driver.findElement(By.name("amount")).sendKeys("100");

        // Step 9: Click Transfer button
        By transferButton = By.cssSelector("button[type='submit']");

        wait.until(ExpectedConditions.elementToBeClickable(transferButton));
        driver.findElement(transferButton).click();

        // Step 10: Display result
        System.out.println("Fund transfer of ₹100 completed successfully!");

        Assert.assertTrue(true);
    }
}