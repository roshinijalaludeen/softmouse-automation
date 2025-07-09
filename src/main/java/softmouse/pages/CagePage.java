package softmouse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class CagePage {
        WebDriver driver;

        By moveAnimalBtn = By.id("moveAnimalBtn");
        By cageInput = By.id("cageNameInput");
        By updateCageBtn = By.id("updateCageBtn");
        By cagesLink = By.linkText("Cages");

        public CagePage(WebDriver driver) {
            this.driver = driver;
        }

        public void moveAnimalToCage(String cageName) {
            driver.findElement(moveAnimalBtn).click();
            driver.findElement(cageInput).sendKeys(cageName);
            driver.findElement(updateCageBtn).click();
        }

        public boolean isCagePresent(String cageName) {
            driver.findElement(cagesLink).click();
            return driver.getPageSource().contains(cageName);
        }
    }

