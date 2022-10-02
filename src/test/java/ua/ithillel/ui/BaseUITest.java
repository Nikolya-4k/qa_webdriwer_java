package ua.ithillel.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ua.ithillel.ui.browser.WebDriverFactory;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseUITest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");

        driver = WebDriverFactory.getDriver(Browser.CHROME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void test() {
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElements(By.name("btnK")).get(1).click();

        Assert.assertEquals(driver.getTitle(), "webdriver - Пошук Google");
    }

    @AfterTest
    public void stop() {
        driver.quit();
    }

}

