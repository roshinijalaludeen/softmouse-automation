package softmouse.tests;

import softmouse.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import softmouse.utils.ScreenshotUtils;

public class BaseTest {

    public WebDriver driver;
    public ConfigReader config;

    @BeforeClass
    public void setup() {
        config = new ConfigReader();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseUrl"));

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.takeScreenshot(driver, result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}