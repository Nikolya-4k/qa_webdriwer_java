package ua.ithillel.site;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.ithillel.ui.browser.WebDriverFactory;
import utils.ConfigProvider;

import java.time.Duration;

public class SignUp {
    private WebDriver driver;

    public String getString() {
        return (RandomStringUtils.randomAlphabetic(10));
    }

//    User user = User.builder()
//            .setUserName("Nikolaas")
//            .setFirstName("Sergey")
//            .setLastName("Churaban")
//            .setEmail("Yasyidad11@boxomail.live")
//            .build();

    @BeforeTest
    public void start() {

        driver = new WebDriverFactory().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void signUp() {
        driver.navigate().to(ConfigProvider.MAIN_URL);
        driver.findElement(By.id("register")).click();
        driver.findElement(By.id("register-username-modal")).sendKeys(getString());
        driver.findElement(By.id("register-first-modal")).sendKeys(getString());
        driver.findElement(By.id("register-last-modal")).sendKeys(getString());
        driver.findElement(By.id("register-email-modal")).sendKeys(getString() + "@boxomail.live");
        driver.findElement(By.id("register-password-modal")).sendKeys(getString());
        driver.findElements(By.className("btn")).get(2).click();

        Assert.assertEquals(driver.findElement(By.id("registration-message")).getText(), "Registration and login successful.");
    }

    @AfterTest
    public void stop() {
        driver.close();
    }

}
