package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;


    public WebDriver initDriver() {
        String browser = System.getProperty("browser");
        System.out.println("Opened The  :" + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless=new"); // Use --headless=new for Chrome 109+
//            options.addArguments("--window-size=1920,1080");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--remote-allow-origins=*"); // Optional if you're facing origin issues
            driver = new ChromeDriver(options);


        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else {
            try {
                throw new Exception("no browser found with given argument :" + browser);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().window().maximize();
        // driver.get(System.getProperty("url"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;

    }


    public WebDriver getDriver() {
        return driver;
    }


}
