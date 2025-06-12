package ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactPageSF extends BasePage {
    private By newContactButton = By.xpath("//button[normalize-space()='New']");
    private By lastNameInput = By.xpath("//input[@name='lastName' and @placeholder='Last Name']");
    private By salutationDropdown = By.xpath("//button[@name='salutation' and contains(@class, 'slds-combobox__input')]");
    private By saveContactButton = By.xpath("//button[normalize-space()='Save']");
    private By toastMessage = By.cssSelector(".toastMessage");
    private By mandatoryFieldEmptyError = By.xpath("//h2[@class='slds-truncate slds-text-heading_medium']");
                           

    public ContactPageSF(WebDriver driver) {
        super(driver);
    }

    public void selectSalutationOption(String optionText) {
    By option = By.xpath("//span[@title='" + optionText + "']");
    waitForElementToBeVisible(option);
    click(option);
    } 

       public String getNotificationToastMsg() {
        return getText(toastMessage);
    }

      public String getMandatoryFieldEmptyErrorMSG() {
        waitForElementToBeVisible(mandatoryFieldEmptyError);
        return getText(mandatoryFieldEmptyError);
    }


    public void addNewContact() {
        waitForElementToBeVisible(newContactButton);
        click(newContactButton);
        waitForElementToBeVisible(lastNameInput);
        click(lastNameInput);
        sendKeys("Test", lastNameInput);
        click(salutationDropdown);
        selectSalutationOption("Dr.");
        click(saveContactButton);

   
    }

        public void contactNotSentMandatoryFields() {
        waitForElementToBeVisible(newContactButton);
        click(newContactButton);
        click(saveContactButton);

   
    }


}