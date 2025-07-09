package softmouse.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import softmouse.pages.LoginPage;
import softmouse.pages.StrainPage;
import softmouse.tests.BaseTest;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import softmouse.pages.LoginPage;
import softmouse.pages.StrainPage;
import softmouse.utils.ConfigReader;

import java.time.Duration;

public class AddStrainTest extends BaseTest {

    private WebDriverWait wait;
    private Actions actions;
    private ConfigReader configReader;

    @BeforeMethod
    public void loginAndNavigateToStrain() {
        // Confirm driver is not null
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized!");
        }

        configReader = config; // You already initialized ConfigReader in BaseTest

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                configReader.getProperty("username"),
                configReader.getProperty("password")
        );

        // 2. Open App Selector and click Colony Module
        WebElement appSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='apps-selected-open']")));
        actions.moveToElement(appSelector).click().perform();

        WebElement colonyModule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Colony']")));
        colonyModule.click();

        // 3. Click on Strain list (id = mouseline)
        WebElement mouselineElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("mouseline")));
        mouselineElement.click();

        // 4. Click on "Add Strain" button
        WebElement addStrainBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("mouselineNewBtn")));
        actions.moveToElement(addStrainBtn).click().perform();
    }

    @Test
    public void testAddNewStrain() {
        StrainPage strainPage = new StrainPage(driver);
        strainPage.addStrain("test_strain_1");
        // Add assert if possible to verify strain added
    }
}