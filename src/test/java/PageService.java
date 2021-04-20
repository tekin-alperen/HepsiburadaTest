import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Random;

public class PageService {
    Elements elements;

    private static final String BASE_URL = "https://www.hepsiburada.com/";
    private static final String baseUrl = "https://www.hepsiburada.com/";
    private static final By btnMyAccount = By.id("myAccount");
    private static final By btnLogin = By.id("login");
    private static final By txtUserName = By.id("txtUserName");
    private static final By txtPassword = By.id("txtPassword");
    private static final By lblName = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div/div/div[2]/div[3]/div[2]/span/a/span[2]");
    private static final By txtSearchArea = By.xpath("//*[@class='desktopOldAutosuggestTheme-input']"); //arama
    private static final By btnSearch = By.cssSelector("div.SearchBoxOld-buttonContainer");
    private static final By chkFirstSeller = By.cssSelector("div > ol > li.box-container.brand > ol > li:nth-child(1) > label");
    private static final By chkSecondSeller = By.cssSelector("div > ol > li.box-container.brand > ol > li:nth-child(2) > label");
    private static final By btnProduct = By.cssSelector("div > div > ul > li:nth-child(2) > div > a > div.product-detail");
    private static final By btnaddToCart = By.id("addToCart");
    private static final By lblCartPopUp = By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/div/div[1]/div[1]/div/span");
    private static final By lblProductName = By.cssSelector("div > h6");
    private static final By lblCartPopUpFrame = By.xpath("/html/body/div[5]/div/div/div/div/div/div");
    private static final By btnBasket = By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/div/div[1]/div[2]/button[1]");
    private static final By lstBasket = By.id("onboarding_item_list");

    String selectOneProduct="";
    String selectSecondProduct="";

    public PageService() {
        elements = new Elements();
    }

    public void setup() {
        elements.driverSetup();
        elements.goUrl(BASE_URL);
    }

    public void baseUrlControl() {
        Assert.assertEquals(elements.currentUrl(), baseUrl);
    }

    public void loginClick() {
        elements.clickElement(btnMyAccount);
        elements.implicitlyWaitElement(15);
        elements.clickElement(btnLogin);
    }

    public void setMail(String userName) {
        elements.getSendKeyElement(txtUserName, userName); //hiroli4856@loopsnow.com
    }

    public void setPassword(String password) {
        elements.getSendKeyElement(txtPassword, password); //HappyTesting123
    }

    public void accountLogin() {
        elements.getSendKey(txtPassword, "\ue004");
        elements.getSendKey(txtPassword, "\ue007");
    }

    public void assertLogin(String name) {
        Assert.assertTrue("hata! isim yanlış :" + name + " gelmesi bekleniyordu.", elements.findElement(lblName).getText().contains(name));
    }

    public void setSearch(String search) {
        elements.getSendKeyElement(txtSearchArea, search);
        elements.sleep(1000);
        elements.clickElement(btnSearch);
    }


    public void firstSellerClick() {
        elements.clickElement(chkFirstSeller);
        elements.implicitlyWaitElement(25);
        elements.scrollElement("150");
        elements.clickElement(btnProduct);
    }

    public void addToCart() {
        elements.implicitlyWaitElement(15);
        elements.clickElement(btnaddToCart);

    }

    public void PopupWait() {
        elements.visibilityOfWaitElement(15, lblCartPopUpFrame);
        elements.visibilityOfWaitElement(15, lblCartPopUp);
    }

    public void assertCart() {

        Assert.assertTrue("hata! ürün sepete eklenmedi", elements.findElement(lblCartPopUp).getText().contains("sepetinizde"));
    }

    public void getOneProductName() {

      selectOneProduct= elements.findElement(lblProductName).getText();
    }
    public void getSecondProductName() {

      selectSecondProduct= elements.findElement(lblProductName).getText();
    }

    public void goBasket() {

        elements.clickElement(btnBasket);
    }

    public void goHome() {
        elements.goUrl(BASE_URL);
    }

    public void returnSearch() {
        elements.clickElement(btnSearch);
    }

    public void secondSellerClick() {
        elements.scrollElement("250");
        elements.visibilityOfWaitElement(15, chkSecondSeller);
        elements.clickElement(chkSecondSeller);
        elements.clickElement(btnProduct);
    }

    public Boolean assertToProduct(){
        if(elements.findElement(lstBasket).getText().contains(selectOneProduct)&&elements.findElement(lstBasket).getText().contains(selectOneProduct)) {
        return true;
        }
        else return false;
    }

    public void closeDriver(){
        elements.closeDriver();
    }
}


