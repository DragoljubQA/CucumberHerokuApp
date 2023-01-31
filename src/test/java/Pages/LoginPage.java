package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement UsernameField;

    @FindBy(id = "password")
    public WebElement PasswordField;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    public WebElement LoginButton;

    //-------------------------

    public void insertUsername(String username) {
        UsernameField.clear();
        UsernameField.sendKeys(username);
    }

    public void insertPassword(String password) {
        PasswordField.clear();
        PasswordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        LoginButton.click();
    }

}
