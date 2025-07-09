import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Specify the report path and file name
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");

            // Configure report title and name
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("SoftMouse Automation Results");

            // Create ExtentReports and attach reporter
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Add system info to the report
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Roshini");
        }
        return extent;
    }
}
