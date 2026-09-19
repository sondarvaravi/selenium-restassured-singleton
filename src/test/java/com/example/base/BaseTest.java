package com.example.base;

import com.example.singleton.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Common base class for all Selenium UI tests.
 * Fetches the WebDriver from the Singleton DriverManager instead of
 * creating a new browser instance per test class.
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getInstance().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }
}
