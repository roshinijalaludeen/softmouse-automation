package softmouse.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import softmouse.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import softmouse.pages.AnimalPage;
import softmouse.pages.LoginPage;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

public class ExportAnimalsTest extends BaseTest {

    private boolean waitForFileToExist(File file, int timeoutSeconds) {
        Instant end = Instant.now().plus(Duration.ofSeconds(timeoutSeconds));
        while (Instant.now().isBefore(end)) {
            if (file.exists()) {
                return true;
            }
            try {
                Thread.sleep(500); // poll every 500ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return false;
    }

    @Test
    public void testExportAnimalList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // 1. Login
        new LoginPage(driver).login(config.getProperty("username"), config.getProperty("password"));


        // 2. Open App Selector
        WebElement appSelector = wait.until(ExpectedConditions.elementToBeClickable(By.id("apps-selected-open")));
        actions.moveToElement(appSelector).click().perform();

        // 3. Click on Colony module
        WebElement colonyModule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Colony']")));
        colonyModule.click();

        // 4. Click the Export to Spreadsheet icon
        new AnimalPage(driver).exportAnimalList();

        // 5. Wait for file download
        File file = new File(System.getProperty("user.home") + "/Downloads/Animals.csv");
        boolean fileDownloaded = waitForFileToExist(file, 30); // wait up to 60 seconds

        // 6. Switch to the newly opened tab
        String originalWindow = driver.getWindowHandle();
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // 7. Read page text and verify export message
            String bodyText = driver.findElement(By.tagName("body")).getText();
            if (bodyText.contains("Your data has been successfully exported")) {
                System.out.println("✅ File exported successfully.");
            } else {
                System.out.println("❌ Export failed or confirmation text not found.");
                Assert.fail("Expected export success text not found.");
            }

            // Step 6: Close export tab and switch back
            driver.close();
            driver.switchTo().window(originalWindow);
    }

}