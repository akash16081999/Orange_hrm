package com.qa.base;

import com.qa.pages.PageManager;
import com.qa.utils.ConfigReader;
import com.qa.utils.Reporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    private WebDriver driver;


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ConfigReader.intConfigReader();

        Reporter.initReporter();



    }

    @BeforeMethod(alwaysRun = true)
    public void openUrl() {
       // System.out.println("before Method");
        DriverFactory factory = new DriverFactory();

        driver = factory.initDriver();
        PageManager.intPageManager(driver);

        driver.get(System.getProperty("url"));


    }

    @AfterMethod(alwaysRun = true)
    public void quiteSession() {

        //driver.quit();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Reporter.getFlushExtentReport();


    }

    public WebDriver getDriver() {
        return driver;
    }
}
