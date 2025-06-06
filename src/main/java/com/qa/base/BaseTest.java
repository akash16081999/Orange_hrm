package com.qa.base;

import com.qa.utils.ConfigReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private DriverFactory factory;


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ConfigReader.intConfigReader();
        factory = new DriverFactory();
        factory.initDriver();
        System.out.println("Base Test Executed");


    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        factory.getDriver().quit();

    }
}
