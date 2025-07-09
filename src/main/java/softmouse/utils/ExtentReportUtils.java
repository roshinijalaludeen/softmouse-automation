package softmouse.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Initialize ExtentReports and attach the Spark reporter
    public static void initReports() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extent-report.html");
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("SoftMouse Automation Report");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Roshini");
            extent.setSystemInfo("Environment", "QA");
        }
    }

    public static ExtentTest createTest(String testName) {
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
        return extentTest;
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
