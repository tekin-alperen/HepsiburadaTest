import org.junit.Test;

public class BaseTest {
    @Test
    public void testOne() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        PageService pageService = new PageService();
        pageService.setup();
        pageService.baseUrlControl();
        pageService.loginClick();
        pageService.setMail("hiroli4856@loopsnow.com");
        pageService.setPassword("HappyTesting123");
        pageService.accountLogin();
        pageService.assertLogin("Hiroli");
        pageService.setSearch("Satranç Takımı");
        pageService.firstSellerClick();
        pageService.addToCart();
        pageService.PopupWait();
        pageService.assertCart();
        pageService.getName();
        pageService.goBasket();
        pageService.goHome();
        pageService.returnSearch();
        pageService.secondSellerClick();
        pageService.addToCart();
        pageService.PopupWait();
        pageService.assertCart();
        pageService.goBasket();
        pageService.closeDriver();

    }
}
