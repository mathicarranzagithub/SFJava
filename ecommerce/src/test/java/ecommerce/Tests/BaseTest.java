package ecommerce.Tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import ecommerce.utils.Config;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected static Config config = new Config();
    protected String baseUrl;

    @BeforeMethod
    public void setupDriverConnection() {
        WebDriverManager.chromedriver().setup(); // Automatically manages ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        driver.manage().window().maximize();

        baseUrl = config.getProperty("baseUrl");
    }

    @AfterMethod
    public void closeDriverConnection() throws InterruptedException {
         Thread.sleep(1000);
         if (driver != null) {
             driver.quit();
         }
    }
}
