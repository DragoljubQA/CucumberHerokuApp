package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    public LogoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".icon-2x.icon-signout")
    public WebElement LogoutButton;

    @FindBy(id = "flash")
    public WebElement Notification;

    //-------------------------

    public void clickOnLogoutButton() {
        LogoutButton.click();
    }

}
