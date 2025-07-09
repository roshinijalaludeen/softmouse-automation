package softmouse.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import softmouse.pages.AnimalPage;
import softmouse.pages.LoginPage;

import java.time.Duration;

public class PrintAnimalList extends BaseTest {

    @Test
    public void testEditAnimalAndVerifyPDF() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // 1. Login
        new LoginPage(driver).login(config.getProperty("username"), config.getProperty("password"));

        // 2. Go to Colony > Animals
        WebElement appSelector = wait.until(ExpectedConditions.elementToBeClickable(By.id("apps-selected-open")));
        actions.moveToElement(appSelector).click().perform();

        WebElement colonyModule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Colony']")));
        colonyModule.click();

        // 3–4: Select animal and click Edit
        AnimalPage animalPage = new AnimalPage(driver);
        animalPage.selectAnimalAndClickEdit();

        // 5–6: Change strain and click Save + Return to List
        animalPage.changeStrainAndSave("262868");

        // 7. Verify return to Animal List
        boolean isOnAnimalListPage = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//*[contains(text(),'Animal List')]"),
                "Animal List"
        ));
        System.out.println("✅ Returned to Animal List page: " + isOnAnimalListPage);

        // 8. Click print to PDF and verify export message

        animalPage.clickPrintToPDF();


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
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    By.tagName("body"),
                    "Your data has been successfully exported"
            ));
            System.out.println("✅ File exported successfully.");
        } catch (Exception e) {
            System.out.println("❌ Export failed or confirmation text not found.");
            Assert.fail("Expected export success text not found.");
        } {
            System.out.println("✅ File exported successfully.");
        }


        // Step 6: Close export tab and switch back
        driver.close();
        driver.switchTo().window(originalWindow);
    }
}
