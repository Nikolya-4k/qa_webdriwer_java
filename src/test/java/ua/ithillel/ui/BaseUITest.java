package ua.ithillel.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ua.ithillel.ui.browser.WebDriverFactory;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseUITest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void test() {
        driver.navigate().to("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
//        driver.findElements(By.name("btnK")).get(1).click();
        element.sendKeys("webdriver");
        element.submit();

        Assert.assertTrue(driver.getTitle().contains("webdriver"));
    }

    @AfterTest
    public void stop() {
        driver.quit();
    }

}

