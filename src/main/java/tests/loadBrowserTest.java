package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.BaseTest;
import utilities.TestDataProvider;

public class loadBrowserTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void loadBrowserTest(String browser, String baseUrl) {
    	driver = loadBrowser(browser);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }


}
