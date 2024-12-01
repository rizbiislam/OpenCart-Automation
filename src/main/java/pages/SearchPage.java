package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By searchBox = By.xpath("//input[@name='search']");
    private By searchButton = By.xpath("//button[@data-lang = 'en-gb']");
    public void enterSearchTerm(String term) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).sendKeys(term);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void openNewPage() {
        wait.until(ExpectedConditions.urlContains("search"));
    }

	public boolean isProductListVisible() {
		By productList = By.xpath("//div[@id = 'product-list']");
		return !driver.findElements(productList).isEmpty();
		
	}
}
