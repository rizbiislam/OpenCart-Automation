package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import utilities.BaseTest;
import utilities.TestDataProvider;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "searchData", dataProviderClass = TestDataProvider.class)
    public void searchTest(String browser, String baseUrl, String searchTerm) {
        driver = loadBrowser(browser);
        driver.get(baseUrl);

        driver.manage().window().maximize();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchTerm(searchTerm);
        searchPage.clickSearchButton();
        searchPage.openNewPage();

        if (!searchPage.isProductListVisible()) {
            System.out.println("No products found for search term: " + searchTerm);
            captureScreenshot("NoProductsFound");
            tearDown();
            return;
        }
        
        ProductDetailsPage productPage = new ProductDetailsPage(driver);

        productPage.getFirstProductTitle();
        //Assert.assertNotNull(productTitle, "Product title is missing!");
        //System.out.println("First Product Title: " + productTitle);

        productPage.getFirstProductPrice();
        productPage.getFirstProducttax();
        //Assert.assertNotNull(productPrice, "Product price is missing!");
        //System.out.println("First Product Price: " + productPrice);

        // Add the product to the cart
        //productPage.addToCart();
        //System.out.println("Product added to the cart!");

        captureScreenshot("searchTest");
        tearDown();
    }
}
