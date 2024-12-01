package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By myAccount = By.xpath("//div[@class='dropdown']//span[contains(text(), 'My Account')]");
    private By loginId = By.xpath("//ul[contains(@class, 'dropdown-menu')]//a[contains(text(), 'Login')]");
    private By emailField = By.xpath("//input[@name='email' and @id='input-email']");
    private By passwordField = By.xpath("//input[@name='password' and @id='input-password']");
    private By loginButton = By.xpath("//button[@type='submit' and contains(text(), 'Login')]");

    private By logout = By.xpath("\"//a[text()='Logout']");
    
    public void findAccount(){
    	wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
    	//driver.findElement(myAccount).click();
    	
    }
    public void findLogin() {
    	wait.until(ExpectedConditions.elementToBeClickable(loginId)).click();
    	//driver.findElement(loginId).click();
    	
    }
    

    public void enterUsername(String email) {
    	wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
        
    }

    public void enterPassword(String password) {
    	wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        
    }

    public void clickLogin() {
    	wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        
    }
    
    public void Logout() {
    	
    	WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", logoutButton);
    	logoutButton.click();

    }
}
