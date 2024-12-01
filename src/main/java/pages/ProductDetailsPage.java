package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By firstProductTitle = By.xpath("//div[@class='description']//h4/a");
    private By firstProductPrice = By.xpath("//span[@class = 'price-new']");

    private By firstProductTax = By.xpath("//div[@class='price']/span[@class = 'price-tax']");
    private By addToCartButton = By.xpath("//div[@class='button-group']/button[@type='submit'][1]");
    private By whitelistButton = By.xpath("//div[@class='button-group']/button[@type='submit'][2]");
    private By comphareButton = By.xpath("//div[@class='button-group']/button[@type='submit'][3]");

    public void getFirstProductTitle() {
        WebElement productTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductTitle));
        
        System.out.println("First Product Title: " + productTitleElement.getText());
    }
    
    private void scrollIntoView(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void getFirstProductPrice() {
        WebElement productPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductPrice));
        //scrollIntoView(productPriceElement);
        //productPriceElement.getText();

        System.out.println("First Product Price: " + productPriceElement.getText());
    }
    
    public void getFirstProducttax() {
        WebElement productTaxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductTax));
        
        //productPriceElement.getText();

        System.out.println("First Product Tax: " + productTaxElement.getText());
    }

    // Add product to cart
    public void addToCart() {
       WebElement addToCart =  wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
       scrollIntoView(addToCart);
       addToCart.click();
    }
}
