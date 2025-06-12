package ecommerce.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12)); // Updated WebDriverWait constructor
    }

    // Wait for an element to be visible
    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for an element to be clickable
    protected WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findElement(By locator) {
        return waitForElementToBeVisible(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public void sendKeys(String inputText, By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.clear(); // Clear the field before entering text
        element.sendKeys(inputText);
    }

    public void click(By locator) {
        waitForElementToBeClickable(locator).click();
    }

    public void clear(By locator) {
        WebElement element = findElement(locator);
        element.clear();
    }

    public void waitMilliseconds(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void goToUrl(String url) {
    driver.get(url);
}

    
}
