package listeners;

import com.qa.utils.Reporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.qa.utils.Reporter;

public class MyListener implements ITestListener {


    public void onTestStart(ITestResult result) {
        Reporter.createTest(result.getName());

    }


    public void onTestSuccess(ITestResult result) {
        Reporter.testPass(result);
    }


    public void onTestFailure(ITestResult result) {
        Reporter.testFail(result);
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
