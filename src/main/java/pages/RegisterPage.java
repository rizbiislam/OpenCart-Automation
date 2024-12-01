package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    
    private By registerId = By.xpath("//ul[contains(@class, 'dropdown-menu')]//a[contains(text(), 'Register')]");
    private By firstNameField = By.xpath("//input[@id='input-firstname']");
    private By lastNameField = By.xpath("//input[@id='input-lastname']");
    private By emailField = By.xpath("//input[@id='input-email']");
    private By passwordField = By.xpath("//input[@id='input-password']");
    private By newslatterCheckbox = By.xpath("//input[@name = 'newsletter']");
    private By agreeCheckbox = By.xpath("//input[@name = 'agree']");
    private By registerButton = By.xpath("//button[text()='Continue']");
    
    
    public void findRegister(){
    	driver.findElement(registerId).click();
    	//driver.findElement(By.id("content"));
    	
    }
    


    public void enterFirstName(String firstName) {
    	wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
    	wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).sendKeys(lastName);
    }

    public void enterEmail(String email) {
    	wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
    	wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }
    private void scrollIntoView(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    

    /*public void agreeToNewsleeter() {
    	WebElement newsElement = wait.until(ExpectedConditions.elementToBeClickable(newslatterCheckbox));
    	scrollIntoView(newsElement);
    	newsElement.click(); 
    }*/

    public void agreeToTerms() {
    	WebElement agreeElrment = wait.until(ExpectedConditions.elementToBeClickable(agreeCheckbox));
    	scrollIntoView(agreeElrment);
    	agreeElrment.click();
    	
    }

    public void clickRegister() {
    	WebElement registerElrment = wait.until(ExpectedConditions.elementToBeClickable(registerButton));
    	scrollIntoView(registerElrment);
    	registerElrment.click();
    }
    public void scrollToContent() {
        WebElement content = driver.findElement(By.id("content"));
        scrollIntoView(content);
    }
    
    
    
}
