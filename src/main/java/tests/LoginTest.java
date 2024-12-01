package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;
import utilities.TestDataProvider;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void loginTest(String browser, String baseUrl, String email, String password) {
    	driver = loadBrowser(browser);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.findAccount();
        loginPage.findLogin();
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
		//Thread.sleep(5000);
        //loginPage.Logout();

        captureScreenshot("loginTest");
        tearDown();
    }
}
