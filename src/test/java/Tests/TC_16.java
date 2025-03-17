package Tests;

import Pages.P01_RegisterPage;
import Pages.P06_CartPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_16 extends BaseTest {
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String pass = DataUtils.getJsonData("validLogin", "pass");
    private final String text = DataUtils.getJsonData("validLogin", "text");
    private final String nameCard = DataUtils.getJsonData("validLogin", "NameOnCard");
    private final String CardNumber = DataUtils.getJsonData("validLogin", "CardNumber");
    private final String CVC = DataUtils.getJsonData("validLogin", "CVC");
    private final String EXP = DataUtils.getJsonData("validLogin", "EXP");
    private final String YY = DataUtils.getJsonData("validLogin", "YY");

    @Test
    public void PlaceOrderLoginBeforeCheckout() throws InterruptedException {
        Assert.assertEquals(new P01_RegisterPage(getDriver())
                .navigateToLoginPage()
                .validLogin(mail, pass)
                .AddProductsHomePage().NavigateToCartPage()
                .Checkout(text, nameCard, CardNumber, CVC, EXP, YY)
                , "ORDER PLACED!");
        //  .DeleteACC();
        //Assert.assertEquals("ACCOUNT DELETED!",new P02_HomePage(getDriver()).VerifyAccDeleted());


    }
}
