package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    private By myAccount = By.xpath("//div[@class='dropdown']//span[contains(text(), 'My Account')]");
    private By loginBtn = By.cssSelector("//ul[contains(@class, 'dropdown-menu')]//a[contains(text(), 'Login')]");
    private By desktops = By.xpath("//a[@data-bs-toggle = 'dropdown' and contains(text(), 'Desktops')]");
    private By showAllDesktops = By.xpath("//a[contains(text(), 'Show All Desktops')]");
    private By HP_LP3065 = By.xpath("//div[@id='product-list']//div[@class='product-thumb' and .//h4/a[text()='HP LP3065']]");
    private By addToCart = By.xpath("//div[@id='product-list']//div[@class='product-thumb' and .//h4/a[text()='HP LP3065']]//button[@title='Add to Cart']");

    //private By HP_LP3065 = By.cssSelector("div.product-thumb img[alt='HP LP3065']"); or div.product-thumb img[alt="HP LP3065"]
    //private By addToCart = By.xpath("//div[@id='product-list']//div[@class='product-thumb' and .//h4/a[text()='HP LP3065']]//button[@title='Add to Cart']");
    
    
    /*private By cart = By.xpath("//div[@id = 'header-cart']//button[@type = 'button']");
    private By checkout = By.xpath("//a[@class = 'check_out']");
    private By viewCart = By.xpath("//a[@class = 'check_out1']");*/
    
    private By cart = By.xpath("//span[contains(text(), 'Shopping Cart')]"); // //li[@class='list-inline-item' and contains(., 'Shopping Cart')]
    private By checkout = By.xpath("//li[@class='list-inline-item' and contains(., 'Checkout')]");
    private By viewCart = By.xpath("//a[@class = 'check_out1']");
    
    private By qtyInput = By.id("input-quantity");
    private By qtyError = By.xpath("//*[@id=\"product-product\"]/div[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Helper method to wait and click
    private void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    
    private void waitAndSendKeys(By locator, String keys) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(keys);
    }

    public void clickMyAccount() {
        waitAndClick(myAccount);
    }

    public void clickLogin() {
        waitAndClick(loginBtn);
    }

    public void clickDesktop() {
        waitAndClick(desktops);
    }

    public void clickShowAllDesktops() {
        waitAndClick(showAllDesktops);
    }

    public void selectProduct(String productName) {
        driver.findElement(By.partialLinkText(productName)).click();
    }

    public void addProductToCart() {
        waitAndClick(addToCart);
    }

    public void viewCart() {
        waitAndClick(cart);
    }

    public void clickCheckout() {
        waitAndClick(checkout);
    }

    public void enterQty(String qty) {
        waitAndSendKeys(qtyInput, qty);
    }

    public String getQtyErrorMessage() {
        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(qtyError)).getText();
        return error.substring(0, error.length() - 2);
    }
}
