package softmouse.pages;

import org.openqa.selenium.support.ui.Select;
import softmouse.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AnimalPage extends BasePage {

    private WebDriverWait wait;

    public AnimalPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void exportAnimalList() {
        WebElement exportButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("exportMouseMenuButton")));
        exportButton.click();
    }

    public void selectAnimalAndClickEdit() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("jqg_mouseTable_26999646")));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("editMouseMenuButton")));
        editButton.click();
    }

    public void changeStrainAndSave(String strainValue) {
        WebElement strainDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mouselineId")));
        Select select = new Select(strainDropdown);
        select.selectByValue(strainValue);

        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("editSaveAndBack")));
        saveBtn.click();
    }

    public void clickPrintToPDF() {
        WebElement printBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("printMouseMenuButton")));
        printBtn.click();
    }

    public void selectFirstAnimal() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("jqg_mouseTable_26999646")));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
