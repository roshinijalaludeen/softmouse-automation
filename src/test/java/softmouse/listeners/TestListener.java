package softmouse.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import softmouse.utils.ExtentReportUtils;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportUtils.initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportUtils.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportUtils.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtils.getTest().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportUtils.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtils.flushReports();
    }
}
