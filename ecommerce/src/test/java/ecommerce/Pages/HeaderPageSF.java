package ecommerce.Pages;

import org.openqa.selenium.WebDriver;


public class HeaderPageSF extends BasePage {
    private String contactsURL = "https://orgfarm-7a61d3dce4-dev-ed.develop.lightning.force.com/lightning/o/Contact/pipelineInspection";

    public HeaderPageSF(WebDriver driver) {
        super(driver);
    }

    public void visitContactsTab() {
        goToUrl(contactsURL);
        waitMilliseconds(5000);
   
    }


}