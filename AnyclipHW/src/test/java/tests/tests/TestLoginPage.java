package tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.repository.Repository;

public class TestLoginPage extends TestBase implements Repository {
    @Test
    public void testLogin () {
        loginUser(EMAIL, PASSWORD, REMEMBER_ME);
    }

    @Test
    public void testLogin2users () {
        loginUser(EMAIL, PASSWORD, REMEMBER_ME);
        returnToLoginPage();
        loginUser(EMAIL1, PASSWORD1, REMEMBER_ME);
    }

    public void loginUser (String email, String password, Boolean checkbox) {
        //1. Make sure you are in the login page.
        Assert.assertTrue(app.returnCurrentURL().equals(START_URL), "Wrong starting URL.");

        //2. Input username and password
        app.type(EMAIL_INPUT, email);
        app.type(PASSWORD_INPUT,password);

        //3. Tick a "Remember Me" checkbox (Optional. In another case it won't be checked.)
        if (checkbox == true) {
            app.click(REMEMBER_ME_CHECKBOX);
        }

        //4. Click on the "Login" button.
        app.click(LOGIN_BUTTON);

        //5. Make sure login successful. Checking what has appeared dropdown toggle "Profile"
        Assert.assertTrue(app.isElementPresent(By.xpath(PROFILE)), "Login of user " +email +" is not successful.");
    }

    public void returnToLoginPage () {
        app.click(PROFILE);
        app.click(LOGOUT);
        app.click(LOGIN);
    }
}
