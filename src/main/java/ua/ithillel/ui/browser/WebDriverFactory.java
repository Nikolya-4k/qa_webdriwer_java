package ua.ithillel.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigProvider;

import java.time.Duration;

import static utils.ConfigProvider.BROWSER;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        driver = getDriver(Browser.valueOf(BROWSER.toUpperCase()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
        return driver;
    }

    public WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalCallerException("Wrong browser type provided. Choices are: chrome, firefox");
        }

    }

    private WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage();
        }
        return driver;
    }

    private WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}