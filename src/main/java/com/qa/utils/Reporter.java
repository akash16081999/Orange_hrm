package com.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;

import java.util.Arrays;

public class Reporter {

    private static ExtentReports reports;
    private static ExtentTest test;

    public static void initReporter() {

        reports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        reports.attachReporter(sparkReporter);


    }

    public static void createTest(String testName) {
        test = reports.createTest( "TEST CASE NAME : "+testName);
    }

    public static void testPass(ITestResult result) {

        test.pass("TEST CASE PASSED : "+result.getName());
    }

    public static void testFail(ITestResult result) {
        test.fail("TEST FAILED : " + Arrays.toString(result.getThrowable().getStackTrace()), MediaEntityBuilder.createScreenCaptureFromPath("//screenshot").build());



    }

    public static Status getTestStatus() {
        return test.getStatus();
    }


    public static void getFlushExtentReport() {
        reports.flush();

    }


}
