package ecommerce.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ecommerce.Pages.LoginPage;

@Test(groups = "Login")
public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        driver.get(baseUrl); // Using baseUrl from BaseTest
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.enterEmail("invalid@example.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password");
    }

    @Test
    public void testLoginWithEmptyEmail() {
        loginPage.enterPassword("somepassword");
        loginPage.clickLogin();
        // Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or
        // password");
    }

    @Test
    public void testLoginWithEmptyPassword() {
        loginPage.enterEmail("user@example.com");
        loginPage.clickLogin();
        // Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or
        // password");
    }

    @Test
    public void testRegisterLink() {
        loginPage.clickRegisterLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicesoftwaretesting.com/auth/register");
    }

    @Test(priority = 1)
    public void testForgotPasswordLink() {
        loginPage.clickForgotPasswordLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicesoftwaretesting.com/auth/forgot-password");
    }
}