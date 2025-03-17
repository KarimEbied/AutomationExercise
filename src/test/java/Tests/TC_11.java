package Tests;

import Pages.P06_CartPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

@Test
public class TC_11 extends BaseTest{
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");

    public void SubscriptionCartPage(){
        P06_CartPage cartPage = new P06_CartPage(getDriver());
        Assert.assertEquals(cartPage.VerifySubscription(),"SUBSCRIPTION");
        Assert.assertEquals(cartPage.Subscription(mail),"You have been successfully subscribed!");


    }
}
