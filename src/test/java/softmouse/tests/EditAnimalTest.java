package softmouse.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import softmouse.pages.AnimalPage;
import softmouse.pages.LoginPage;

import java.time.Duration;

public class EditAnimalTest extends BaseTest {

    @Test
    public void testEditAnimal() {
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
        new AnimalPage(driver).selectAnimalAndClickEdit();

        // 5–6: Change strain and click Save + Return to List
        AnimalPage animalPage = new AnimalPage(driver);
        animalPage.changeStrainAndSave("262868");

        boolean isOnAnimalListPage = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//*[contains(text(),'Animal List')]"),
                "Animal List"
        ));
    }
}
