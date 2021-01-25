import org.junit.Test;

public class Tests {

    PageModel pageModel = new PageModel();


    @Test
    public void HavaleTest() {
        pageModel.setUp("Chrome");
        pageModel.baseUrlAssertion();
        pageModel.hoverLogin();
        pageModel.loginClick();
        pageModel.loginUrlAssertion();
        pageModel.setMail("hiroli4856@loopsnow.com");
        pageModel.setPassword("HappyTesting123");
        pageModel.loginPageClick();
        pageModel.setSearch("kitap");
        pageModel.searchClick();
        pageModel.productClick();
        pageModel.randomProduct();
        pageModel.addToCart();
        pageModel.closePopUp();
        pageModel.basket();
        pageModel.nextStepClıck();
        pageModel.doneShoping();
        pageModel.continueShopping();
        pageModel.selectPaymnet();
        pageModel.hoverLogin();
        pageModel.loginClick();
    }

}
