
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class PageModel extends SeleniumElements {

    public WebDriver driver;
    public WebDriverWait wait;

    By btnAccount = By.id("myAccount");
    By btnLogin = By.id("login");
    By txtUserName = By.id("txtUserName");
    By txtPassword = By.id("txtPassword");
    By btnLoginPage = By.id("btnLogin");
    By txtSearch = By.xpath("//*[@id='SearchBoxOld']/div/div/div[1]/div[2]/input");
    By btnSearch = By.xpath("//*[@id='SearchBoxOld']/div/div/div[2]");
    By lstProduct = By.cssSelector("#productresults > div.with-hover.big-box");
    By btnaddToCart = By.id("addToCart");
    By btnclose = By.cssSelector("div.sf-SalesFrontCash-y0CGk > div.sf-SalesFrontCash-3zIbr.hb_sfc_close");
    By myBasket = By.cssSelector("div.sf-OldMyAccount-2sc8o > a");
    By btnContinueStep = By.id("continue_step_btn");
    By btnContinueStepToCard = By.id("continue_step_btn");
    By chkPayment = By.id("//*[@id='payment-methods']/div[2]/div/div[1]/div[2]/div");
    By chkBank = By.id("//*[@id='payment-money-transfer']/div/div[2]/div[1]/div[1]/label/input");
    By chkEft = By.id("//*[@id='payment-money-transfer']/div/div[2]/div[2]/div/form/div/label/label/input");


    public void setUp(String driver) {
        setUpElement(driver);
    }

    public void hoverLogin() {
        hoverElement(btnLogin);
    }

    public void loginClick() {
        clickElement(btnLogin);
    }

    public void setMail(String mail) {
        sendKeyElement(txtUserName, mail);
    }

    public void setPassword(String password) {
        sendKeyElement(txtPassword, password);
    }

    public void loginPageClick() {
        clickElement(btnLogin);
    }

    public void setSearch(String search) {
        sendKeyElement(txtSearch, search);
        waitElement(20);
    }

    public void searchClick() {
        clickElement(btnSearch);
        WaitForPageLoad(driver);
    }

    public void productClick() {
        clickElement(lstProduct);
        waitElement(20);
    }

    public void randomProduct() {
        List<WebElement> links = driver.findElements(lstProduct);
        links.get(new Random().nextInt(links.size())).click();
    }

    public void addToCart() {
        clickElement(btnaddToCart);
        waitElement(20);
    }

    public void closePopUp() {
        clickElement(btnclose);
        waitElement(20);
    }

    public void basket() {
        WaitForPageLoad(driver);
        clickElement(myBasket);
    }

    public void nextStepClıck() {
        WaitForPageLoad(driver);
        clickElement(btnContinueStep);
    }

    public void doneShoping() {
        clickElement(btnContinueStepToCard);
        waitElement(20);
    }

    public void continueShopping() {
        clickElement(btnContinueStepToCard);
        waitElement(20);
    }

    public void selectPaymnet() {
        WaitForPageLoad(driver);
        waitElement(20);
        clickElement(chkPayment);
        waitElement(20);
        clickElement(chkBank);
        waitElement(20);
        clickElement(chkEft);
        waitElement(20);
        clickElement(btnContinueStepToCard);
        waitElement(20);
    }

    public void after() {
        driver.quit();
    }

    public void baseUrlAssertion() {
        String actualUrl = ("https://www.hepsiburada.com/");
        String exceptUrl = driver.getCurrentUrl();
        Assert.assertEquals(exceptUrl, actualUrl);
    }

    public void loginUrlAssertion() {
        assertElement("https://giris.hepsiburada.com/");
    }


}
