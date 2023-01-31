package Steps;

import Pages.LoginPage;
import Pages.LogoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepsDefinition {

    public WebDriver driver;
    public LoginPage loginPage;
    public LogoutPage logoutPage;
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("User inserts username")
    public void userInsertsUsername() {
        loginPage.insertUsername("tomsmith");
    }

    @When("User inserts username {string}")
    public void userInsertsInvalidUsername(String username) {
        loginPage.insertUsername(username);
    }

    @And("User inserts password {string}")
    public void userInsertsInvalidPassword(String password) {
        loginPage.insertPassword(password);
    }

    @And("User inserts password")
    public void userInsertsPassword() {
        loginPage.insertPassword("SuperSecretPassword!");
    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("User is logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(logoutPage.LogoutButton.isDisplayed());
        Assert.assertTrue(logoutPage.Notification.isDisplayed());
    }

    @Then("User is not logged in")
    public void userIsNotLoggedIn() {
        Assert.assertTrue(loginPage.UsernameField.isDisplayed());
        Assert.assertTrue(loginPage.PasswordField.isDisplayed());
    }

}
