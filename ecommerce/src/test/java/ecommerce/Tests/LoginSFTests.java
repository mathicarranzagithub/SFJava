package ecommerce.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ecommerce.Pages.LoginPageSF;
import ecommerce.utils.Config;


@Test(groups = "Login")
public class LoginSFTests extends BaseTest {
    private LoginPageSF loginPageSF;
    protected static Config config = new Config();

    String sfEmail = config.getProperty("sfEmail");
    String sfPassword = config.getProperty("sfPassword");



    @BeforeMethod
    public void setUpTest() {
        driver.get(baseUrl); // Using baseUrl from BaseTest
        loginPageSF = new LoginPageSF(driver);

    }

    @Test
    public void validLoginTest() {
        
        loginPageSF.loginSF(sfEmail,sfPassword);
        Assert.assertEquals(loginPageSF.getAppText(), "QA Automation App");

    }


}