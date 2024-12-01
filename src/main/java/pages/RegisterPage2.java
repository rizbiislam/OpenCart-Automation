package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage2 {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time
    }

    // Locators
    private By registerId = By.xpath("//ul[contains(@class, 'dropdown-menu')]//a[contains(text(), 'Register')]");
    private By firstNameField = By.xpath("//input[@id='input-firstname']");
    private By lastNameField = By.xpath("//input[@id='input-lastname']");
    private By emailField = By.xpath("//input[@id='input-email']");
    private By passwordField = By.xpath("//input[@id='input-password']");
    private By newsletterCheckbox = By.xpath("//input[@class = 'form-check-input' and @name = 'newsletter']");
    private By agreeCheckbox = By.xpath("//input[@class = 'form-check-input' and @name = 'agree']");
    private By registerButton = By.xpath("//button[@type='submit']");

    // Navigate to Register Page
    public void findRegister() {
        try {
            WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(registerId));
            scrollToElement(registerLink);
            registerLink.click();
            System.out.println("Navigated to the Register page.");
        } catch (Exception e) {
            System.out.println("Failed to navigate to the Register page: " + e.getMessage());
        }
    }

    // Scroll Helper Method
    private void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        } catch (Exception e) {
            System.out.println("Failed to scroll to element: " + e.getMessage());
        }
    }

    // Input Fields
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

    // Click Newsletter Checkbox
    public void agreeToNewsletter() {
        try {
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(newsletterCheckbox));
            scrollToElement(checkbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            System.out.println("Newsletter checkbox clicked.");
        } catch (Exception e) {
            System.out.println("Failed to click the Newsletter checkbox: " + e.getMessage());
        }
    }

    // Click Agree to Terms Checkbox
    public void agreeToTerms() {
        try {
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(agreeCheckbox));
            scrollToElement(checkbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            System.out.println("Agree to terms checkbox clicked.");
        } catch (Exception e) {
            System.out.println("Failed to click the Agree to Terms checkbox: " + e.getMessage());
        }
    }

    // Click Register Button
    public void clickRegister() {
        try {
            WebElement registerBtn = wait.until(ExpectedConditions.presenceOfElementLocated(registerButton));
            scrollToElement(registerBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerBtn);
            System.out.println("Register button clicked.");
        } catch (Exception e) {
            System.out.println("Failed to click the Register button: " + e.getMessage());
        }
    }
}
