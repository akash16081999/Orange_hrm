package com.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Reporter {

    private static ExtentReports reports;
    private ExtentTest test;

    public static void initReporter() {

        reports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        reports.attachReporter(sparkReporter);


    }


    public void createTest(String testName) {
        test = reports.createTest(testName);
    }

    public void testPass(ITestResult result) {

        test.info(result.getName()).info("TEST PASSED");
    }

    public void testFail(ITestResult result) {
        test.info("Test Failed : " + result.getName());

    }

    public Status getTestStatus() {
        return test.getStatus();
    }


    public static void getFlushExtentReport() {
        reports.flush();

    }


}
