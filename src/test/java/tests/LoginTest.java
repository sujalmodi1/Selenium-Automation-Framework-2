package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {
    // The actual test scenarios
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("/secure"), "Login failed!");
    }

    @Test
    public void testInvalidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("wrongUser");
        loginPage.enterPassword("wrongPass");
        loginPage.clickLoginButton();
        String alertText = loginPage.getErrorMessage();
        org.testng.Assert.assertTrue(alertText.contains("Your username is invalid!"), "Error message text mismatch!");
    }
}
