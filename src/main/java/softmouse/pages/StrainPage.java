package softmouse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import softmouse.base.BasePage;

import java.time.Duration;

import softmouse.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StrainPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(id = "name")
    private WebElement strainNameInput;

    @FindBy(id = "editSaveAndBack") // Use correct submit button id here
    private WebElement submitButton;

    public StrainPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void addStrain(String strainName) {
        wait.until(ExpectedConditions.visibilityOf(strainNameInput));
        strainNameInput.clear();
        strainNameInput.sendKeys(strainName);

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }
}