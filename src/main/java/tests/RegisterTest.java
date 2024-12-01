package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.RegisterPage;
import utilities.BaseTest;
import utilities.TestDataProvider;

public class RegisterTest extends BaseTest {

    // Test method now accepts parameters from DataProvider
    @Test(dataProvider = "registerData", dataProviderClass = TestDataProvider.class)
    public void registerTest(String browser, String baseUrl, String firstName, String lastName, String email, String password) {
        driver = loadBrowser(browser);
        driver.get(baseUrl);

        driver.manage().window().maximize();

        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.findAccount();
        registerPage.findRegister();
       // registerPage.scrollToContent();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        
        //registerPage.agreeToNewsleeter();
        registerPage.agreeToTerms();
        registerPage.clickRegister();
        //loginPage.findAccount();
        //loginPage.Logout();

        captureScreenshot("registerTest");
        tearDown();
    }
}
