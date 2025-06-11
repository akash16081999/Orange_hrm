package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static void initDriver() {
        String browser = System.getProperty("browser");


        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                setDriver(new ChromeDriver());
                break;
            case "firefox":
                setDriver(new FirefoxDriver());
                break;
            case "edge":
                setDriver(new EdgeDriver());
                break;
            default:
                try {
                    throw new Exception("no browser found with given argument :" + browser);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    public static void setDriver(WebDriver drive) {
        driver.set(drive);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }


}
