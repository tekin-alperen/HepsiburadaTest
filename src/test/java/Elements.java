import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Elements {

    WebDriver driver;

    public Elements() {

        driver = new ChromeDriver();
    }

    public void driverSetup() {
        driver.manage().window().maximize();
    }

    public void goUrl(String url) {
        driver.get(url);
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void implicitlyWaitElement(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public void visibilityOfWaitElement(int second, By by) {

        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void getSendKeyElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void getSendKey(By by, String key) {

        driver.findElement(by).sendKeys(key);
    }

    public void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void scrollElement(String scroll) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + scroll + ")");

    }

    public void closeDriver() {
        driver.quit();
    }

}
