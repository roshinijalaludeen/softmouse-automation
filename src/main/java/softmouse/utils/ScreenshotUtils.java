package softmouse.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName + "_" + date + ".png";
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName;

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);

        try {
            // ✅ Create the screenshots directory if it doesn’t exist
            Files.createDirectories(destFile.getParentFile().toPath());
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("✅ Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
        }

        return filePath;
    }
}
