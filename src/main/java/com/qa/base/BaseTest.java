package com.qa.base;

import com.qa.pages.PageManager;
import com.qa.utils.ConfigReader;
import com.qa.utils.Reporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ConfigReader.intConfigReader();
        Reporter.initReporter();

    }

    @BeforeMethod(alwaysRun = true)
    public void openUrl() {
        DriverFactory.initDriver();
        PageManager.intPageManager(DriverFactory.getDriver());

        DriverFactory.getDriver().get(System.getProperty("url"));


    }

    @AfterMethod(alwaysRun = true)
    public void quiteSession() {
        DriverFactory.getDriver().quit();

    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Reporter.getFlushExtentReport();


    }


}
