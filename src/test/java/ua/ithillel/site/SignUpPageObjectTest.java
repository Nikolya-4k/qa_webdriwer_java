package ua.ithillel.site;

import model.User;
import org.testng.annotations.Test;
import pages.MainPage;
import ua.ithillel.ui.BaseUITest;

public class SignUpPageObjectTest extends BaseUITest {

    @Test
    public void testSignUpPageObject() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        MainPage.RegisterForm registerForm = mainPage.clickRegister();
        registerForm.fillRegisterForm(User.builder().buildRandomUser());
    }
}
