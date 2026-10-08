package com.banking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionHistoryTest extends BaseTest {

    @Test
    public void transactionHistoryTest() {

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

        // Step 5: Click Transaction History
        By transactionMenu =
                By.cssSelector("a.menu[href='transactions.php']");

        wait.until(ExpectedConditions.elementToBeClickable(transactionMenu));
        driver.findElement(transactionMenu).click();

        // Step 6: Wait for transaction table
        By transactionTable = By.cssSelector("table");

        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionTable));

        // Step 7: Check that transaction history contains Deposit
        String tableText = driver.findElement(transactionTable).getText();

        Assert.assertTrue(
                tableText.contains("Deposit"),
                "Transaction history does not contain Deposit!"
        );

        // Step 8: Check that ₹500 transaction is present
        Assert.assertTrue(
                tableText.contains("500.00"),
                "₹500 transaction was not found!"
        );

        System.out.println("Transaction History opened successfully!");
        System.out.println("₹500 deposit transaction found successfully!");
    }
}