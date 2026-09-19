package com.example.ui;

import com.example.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Pure UI test - only exercises the front end with Selenium + Chrome.
 * The WebDriver comes from the Singleton DriverManager (see BaseTest).
 */
public class GoogleSearchTest extends BaseTest {

    @Test
    public void verifyPageTitleAfterSearch() {
        driver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        searchBox.sendKeys("Selenium TestNG REST Assured framework");
        searchBox.submit();

        wait.until(ExpectedConditions.titleContains("Selenium"));

        String title = driver.getTitle();
        System.out.println("Page title after search: " + title);

        Assert.assertTrue(title.toLowerCase().contains("selenium"),
                "Expected page title to contain 'selenium' but was: " + title);
    }
}
