package com.example.singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//DriverManager - Singleton design pattern implementation.
public class DriverManager {
    private static volatile DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {                    // 1st check
            synchronized (DriverManager.class) {
                if (instance == null) {             // 2nd check
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    //Every subsequent call returns the SAME instance until quitDriver() is called.

    public synchronized WebDriver getDriver() {
        if (driver == null) {
            // Automatically downloads/configures the matching chromedriver binary
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            // options.addArguments("--headless=new"); // uncomment to run headless (e.g. CI)

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    //Quits the browser session and clears the held reference
    public synchronized void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
