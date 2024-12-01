package utilities;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    //private final String baseUrl = "https://demo-opencart.com/";
    @BeforeMethod
    @Step("Setting up WebDriver")
    public void setUp() {
    	
    	/*if (driver == null) {
            driver = loadBrowser("chrome");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();*/
    	
    }

    public WebDriver loadBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    @AfterMethod
    @Step("Tear down WebDriver")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Capture screenshot on failure")
    public void captureScreenshot(String methodName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String path = "screenshots/" + methodName + ".png";
            FileUtils.copyFile(screenshot, new File(path));
            try (FileInputStream inputStream = new FileInputStream(screenshot)) {
                Allure.addAttachment(methodName, "image/png", inputStream, ".png");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDirectory(String dirName) {
        File directory = new File(dirName);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
