package Tests;

import Pages.P02_HomePage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

@Test
public class TC_13 extends BaseTest{
    private final String number = DataUtils.getJsonData("validLogin", "number");


    public void VerifyProductQuantity() {

        P02_HomePage homePage = new P02_HomePage(getDriver());
        Assert.assertEquals(homePage.VerifyProductQuantityInCart(number), "4");
    }
}
