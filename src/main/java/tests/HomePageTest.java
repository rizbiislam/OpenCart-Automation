package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

import utilities.BaseTest;
import utilities.TestDataProvider;

public class HomePageTest extends BaseTest{

    private WebDriver driver;
    private HomePage homePage;
    

    @Test(dataProvider = "homeData", dataProviderClass = TestDataProvider.class)
    public void HomePageTest(String browser, String baseUrl) {
    	driver = loadBrowser(browser);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    
        homePage.clickMyAccount();
        homePage.clickLogin();
        
    }

    @Test(dataProvider = "productCart", dataProviderClass = TestDataProvider.class)
    public void testProductSelectionAndCart(String product) {
    	
        homePage.clickDesktop();
        homePage.clickShowAllDesktops();
        homePage.selectProduct(product);// Data "HP LP3065"
        homePage.addProductToCart();
        
        homePage.viewCart();
        homePage.clickCheckout();
        
        Assert.assertTrue(driver.getTitle().contains("Checkout"));
    }

    @Test(dataProvider = "productQuantity", dataProviderClass = TestDataProvider.class)
    public void testQuantityErrorMessage(String selectproduct, String Quantity) {
        homePage.clickDesktop();
        homePage.clickShowAllDesktops();
        homePage.selectProduct(selectproduct);//Data "HP LP3065"
        homePage.enterQty(Quantity);//Data "invalid"
        String errorMessage = homePage.getQtyErrorMessage();
        Assert.assertEquals(errorMessage, "Please enter a valid quantity.");
    }

    @Test
    public void testLogout() {
        homePage.clickMyAccount();
        
        homePage.clickLogin();
        Assert.assertTrue(driver.getTitle().contains("Your Store"));
    
    }
}
