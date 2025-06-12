package ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageSF extends BasePage {

    // Selectors
    private By emailInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("Login");
    private By appName = By.xpath("//span[@title='QA Automation App']");


    public LoginPageSF(WebDriver driver) {
        super(driver);
    }

    public void loginSF(String email, String password) {
        sendKeys(email, emailInput);
        waitMilliseconds(500);
        sendKeys(password, passwordInput);
        waitMilliseconds(500);
        click(loginButton);
        waitForElementToBeVisible(appName);
        waitMilliseconds(5000);
    }

       public String getAppText() {
        return getText(appName);
    }


}