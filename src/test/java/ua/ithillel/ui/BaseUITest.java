package ua.ithillel.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.ithillel.ui.browser.WebDriverFactory;
public class BaseUITest {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new WebDriverFactory().getDriver();
        setWebDriver(driver);
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().quit();
    }

    public void setWebDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}

