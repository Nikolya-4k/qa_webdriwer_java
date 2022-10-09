package ua.ithillel.site;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.ithillel.ui.browser.WebDriverFactory;
import utils.ConfigProvider;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SignUpAndLoginTest {
    public String getString() {
        return (RandomStringUtils.randomAlphabetic(10));
    }

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void BeforeTest() {
        driver = new WebDriverFactory().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void signUpAndLogin() {

        String username = getString();
        String password = getString();

        driver.navigate().to(ConfigProvider.MAIN_URL);
        driver.findElement(By.id("register")).click();
        driver.findElement(By.id("register-username-modal")).sendKeys(username);
        driver.findElement(By.id("register-first-modal")).sendKeys(getString());
        driver.findElement(By.id("register-last-modal")).sendKeys(getString());
        driver.findElement(By.id("register-email-modal")).sendKeys(getString()+ "@boxomail.live");
        driver.findElement(By.id("register-password-modal")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"register-modal\"]/div/div/div[2]/form/p/button")).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout")));
        driver.findElement(By.id("logout")).findElement(By.xpath("./child::*")).click();

        wait.until(visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).findElement(By.xpath("./child::*")).click();

        wait.until(visibilityOfElementLocated(By.className("modal-content")));
        driver.findElements(By.name("username")).get(0).sendKeys(username);
        driver.findElements(By.name("password")).get(0).sendKeys(password);
        driver.findElement(By.className("fa-sign-in")).click();

        Assert.assertEquals(driver.findElement(By.id("login-message")).getText(), "Login successful.");
    }

    @AfterTest
    public void stop() {
        driver.close();
    }

}
