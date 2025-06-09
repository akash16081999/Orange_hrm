package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    public void onTestStart(ITestResult result) {

        System.out.println("On Test Start :");
    }


    public void onTestSuccess(ITestResult result) {
        // not implemented
    }


    public void onTestFailure(ITestResult result) {

        System.out.println("Test case failed");
    }


    public void onTestSkipped(ITestResult result) {
        // not implemented
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }


    public void onStart(ITestContext context) {
        // not implemented
    }


    public void onFinish(ITestContext context) {
        // not implemented
    }
}
