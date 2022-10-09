package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(TimeoutException.class);
        wait.withMessage("Element is not visible");
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsVisible(WebDriver driver, By by) {
        waitUntilElementIsVisible(driver, driver.findElement(by));
    }

    public static void waitElementToDisappear(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(TimeoutException.class);
        wait.withMessage("Element is not visible");
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
    }
}