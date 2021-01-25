import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumElements {
    public WebDriver driver;
    public WebDriverWait wait;

    public void setUpElement(String driverName) {
        if (driverName == "Chrome") {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 50);
            driver.manage().window().maximize();
            String baseUrl = "https://www.hepsiburada.com/";
            driver.get(baseUrl);
            wait = new WebDriverWait(driver, 100);
        } else {
            //mozilla

        }

    }


    public void clickElement(By by) {
        WaitForPageLoad(driver);
        driver.findElement(by).click();
    }

    public void sendKeyElement(By by, String search) {
        wait = new WebDriverWait(driver, 1000);
        driver.findElement(by).sendKeys(search);
    }

    public void hoverElement(By by) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(by);
        action.moveToElement(we).build().perform();
    }


    public void waitElement(int seconds) {
        wait = new WebDriverWait(driver, seconds);
    }

    public static void WaitForPageLoad(WebDriver driver) {
        waitForDocumentLoad(driver);
        waitForAjaxLoad(driver);
        waitForDocumentLoad(driver);
    }

    private static void waitForDocumentLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return  document.readyState").equals("complete");
            }
        });
    }

    private static void waitForAjaxLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElements(By.cssSelector(".waiting, .tb-loading")).size() == 0;
            }
        });
    }

    public void assertElement(String actualUrl) {
        String exceptUrl = driver.getCurrentUrl();
        Assert.assertEquals(exceptUrl, actualUrl);
    }


}
