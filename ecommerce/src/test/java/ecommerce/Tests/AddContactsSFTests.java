package ecommerce.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ecommerce.Pages.LoginPageSF;
import ecommerce.Pages.HeaderPageSF;
import ecommerce.Pages.ContactPageSF;

@Test(groups = "Contacts")
public class AddContactsSFTests extends BaseTest {
    private LoginPageSF loginPageSF;
    private HeaderPageSF headerPageSF;
    private ContactPageSF contactPageSF;

    @BeforeMethod
    public void setUpTest() {
        driver.get(baseUrl); // Using baseUrl from BaseTest
        loginPageSF = new LoginPageSF(driver);
        headerPageSF = new HeaderPageSF(driver);
        contactPageSF = new ContactPageSF(driver);
    }

    @Test
    public void validLoginTest() {
        String expectedMessageToast = "Contact \"Dr. Test\" was created.";
        loginPageSF.loginSF("enemnogenus699@agentforce.com","RomaBelenOlivera1997");
        Assert.assertEquals(loginPageSF.getAppText(), "QA Automation App");
        headerPageSF.visitContactsTab();
        contactPageSF.addNewContact();
        Assert.assertEquals(contactPageSF.getNotificationToastMsg(), expectedMessageToast);
    }

    @Test
    public void missingMandatoryFieldInContactCreation() {
        loginPageSF.loginSF("enemnogenus699@agentforce.com","RomaBelenOlivera1997");
        Assert.assertEquals(loginPageSF.getAppText(), "QA Automation App");
        headerPageSF.visitContactsTab();
        contactPageSF.contactNotSentMandatoryFields();
        Assert.assertEquals(contactPageSF.getMandatoryFieldEmptyErrorMSG(), "We hit a snag.");
    }
}