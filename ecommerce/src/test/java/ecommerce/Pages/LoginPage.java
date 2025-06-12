package ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Selectors
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");
    private By errorMessage = By.cssSelector("div[data-test='login-error']");
    private By registerLink = By.cssSelector("a[data-test='register-link']");
    private By forgotPasswordLink = By.cssSelector("a[data-test='forgot-password-link']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        sendKeys(email, emailInput);
    }

    public void enterPassword(String password) {
        sendKeys(password, passwordInput);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public void clickRegisterLink() {
        click(registerLink);
    }

    public void clickForgotPasswordLink() {
        click(forgotPasswordLink);
    }
}
