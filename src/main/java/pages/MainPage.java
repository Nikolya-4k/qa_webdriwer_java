package pages;

import element.TextField;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigProvider;
import utils.WaitUtils;

public class MainPage extends Page {

    public static final String TITLE = "WeaveSocks";

    private By registerLink = By.xpath("//a[@data-target='#register-modal']");
    private By logoutLink = By.id("Logout");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return driver.findElements(logoutLink).size() > 0;
    }

    @Override
    public void open() {
        driver.get(ConfigProvider.MAIN_URL);
        ensureOpen();
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public void ensureOpen() {
        WaitUtils.waitUntilElementIsVisible(driver, registerLink);
    }

    public RegisterForm clickRegister() {
        driver.findElement(registerLink).click();
        return new RegisterForm();
    }

    public class RegisterForm {
        private By userName = By.id("register-username-modal");
        private By firstName = By.id("register-first-modal");
        ;
        private By lastName = By.id("register-last-modal");
        ;
        private By email = By.id("register-email-modal");
        ;
        private By password = By.id("register-password-modal");
        ;
        private By registerButton = By.xpath("//button[normalize-space()='Register']\n");

        public void fillRegisterForm(User user) {
            driver.findElement(userName).sendKeys(user.getUserName());
            driver.findElement(firstName).sendKeys(user.getFirstName());
            driver.findElement(lastName).sendKeys(user.getLastName());
            driver.findElement(email).sendKeys(user.getEmail());
            driver.findElement(password).sendKeys(user.getPassword());
            driver.findElement(registerButton).click();
            WaitUtils.waitElementToDisappear(driver, registerButton);
        }
    }
}