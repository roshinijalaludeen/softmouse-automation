package softmouse.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import softmouse.pages.AnimalPage;
import softmouse.pages.LoginPage;

import java.time.Duration;

public class MoveAnimalTest extends BaseTest {

    @Test
    public void testMoveAnimalToCageAndVerify() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1. Login
        new LoginPage(driver).login(config.getProperty("username"), config.getProperty("password"));

        // 2. Go to Colony > Animals
        WebElement appSelector = wait.until(ExpectedConditions.elementToBeClickable(By.id("apps-selected-open")));
        appSelector.click();
        WebElement colonyModule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Colony']")));
        colonyModule.click();

        // 3. Select an animal (assume first checkbox)
        AnimalPage animalPage = new AnimalPage(driver);
        animalPage.selectFirstAnimal(); // Implement this if not already

        // 4. Click Move Animals button
        WebElement moveAnimalsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("moveMouseMenuButton")));
        moveAnimalsBtn.click();


        // 6. Click Create/Update Cages
        WebElement createUpdateBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("moveApply")));
        createUpdateBtn.click();

        // 7. Verify new page contains "Move Summary"
        WebElement moveSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Move Summary')]")));
        Assert.assertTrue(moveSummary.isDisplayed(), "❌ Move Summary not displayed.");
        System.out.println("✅ Animal successfully moved. 'Move Summary' page displayed.");
    }
}
