package softmouse.tests;

import softmouse.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

    public class LoginTest extends BaseTest {

        @Test
        public void testValidLogin() {
            LoginPage loginPage = new LoginPage(driver);

            // Perform login
            loginPage.login(config.getProperty("username"), config.getProperty("password"));

// inside your login test method
            Assert.fail("Failing login test intentionally for verification.");

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//            // Check if error message is present
//            boolean loginFailed = driver.findElements(By.xpath("//*[contains(text(), 'input correct')]")).size() > 0;
//
//            if (loginFailed) {
//                Assert.fail("Login failed: invalid username or password message shown.");
//            }
//
//            // Else wait for something that confirms login success (e.g. dashboard URL or element)
//            boolean loggedIn = wait.until(ExpectedConditions.urlContains("/Home"));
//
//            Assert.assertTrue(loggedIn, "Login succeeded, but dashboard page did not load.");
        }
    }
