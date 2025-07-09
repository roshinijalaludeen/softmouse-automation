package softmouse.pages;

import softmouse.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputUsernameEmail")
    WebElement username;

    @FindBy(id = "inputPassword")
    WebElement password;

    @FindBy(id = "secureLogin")
    WebElement loginBtn;

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}