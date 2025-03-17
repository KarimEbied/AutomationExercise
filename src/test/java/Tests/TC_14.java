package Tests;

import Pages.P01_RegisterPage;
import Pages.P02_HomePage;
import Pages.P05_ProductsPage;
import Pages.P06_CartPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_14 extends BaseTest {
    private final String Name = DataUtils.getJsonData("validLogin", "Name");
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String Lname = DataUtils.getJsonData("validLogin", "Lname");
    private final String pass = DataUtils.getJsonData("validLogin", "pass");
    private final String month = DataUtils.getJsonData("validLogin", "month");
    private final String year = DataUtils.getJsonData("validLogin", "year");
    private final String day = DataUtils.getJsonData("validLogin", "day");
    private final String company = DataUtils.getJsonData("validLogin", "company");
    private final String Add1 = DataUtils.getJsonData("validLogin", "Add1");
    private final String Add2 = DataUtils.getJsonData("validLogin", "Add2");
    private final String country = DataUtils.getJsonData("validLogin", "country");
    private final String state = DataUtils.getJsonData("validLogin", "state");
    private final String city = DataUtils.getJsonData("validLogin", "city");
    private final String zip = DataUtils.getJsonData("validLogin", "Zip");
    private final String mobile = DataUtils.getJsonData("validLogin", "mobile");
    private final String text = DataUtils.getJsonData("validLogin", "text");
    private final String nameCard = DataUtils.getJsonData("validLogin", "NameOnCard");
    private final String CardNumber = DataUtils.getJsonData("validLogin", "CardNumber");
    private final String CVC = DataUtils.getJsonData("validLogin", "CVC");
    private final String EXP = DataUtils.getJsonData("validLogin", "EXP");
    private final String YY = DataUtils.getJsonData("validLogin", "YY");

    @Test
    public void PlaceOrderRegisterwhileCheckout() throws InterruptedException {
        Assert.assertEquals(new P02_HomePage(getDriver())
                .AddProductsHomePage()
                .navigateToLoginPage().
                Signup(Name, mail)
                .EntetACCiNf(pass, day, month, year, Name, Lname, company,
                        Add1, Add2, country, state, city, zip, mobile)
                .createACC()
                .VerifyACcCreated(),"ACCOUNT CREATED!");
        Assert.assertEquals(new P01_RegisterPage(getDriver())
                .ContinueACcCreated()
                .NavigateToCartPage()
                .Checkout(text, nameCard, CardNumber, CVC, EXP, YY)
                ,"ORDER PLACED!");
        Assert.assertEquals(new P06_CartPage(getDriver())
                .orderPlaced()
                .DeleteACC()
                .VerifyAccDeleted()
                ,"ACCOUNT DELETED!");

    }
}
