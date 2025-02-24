package Tests;

import Pages.P02_HomePage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

@Test
public class TC_10 extends BaseTest{
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");

    public void SubscriptionHomePage(){
        P02_HomePage homePage=new P02_HomePage(getDriver());
        Assert.assertEquals(homePage.VerifySubscription(),"SUBSCRIPTION");
        Assert.assertEquals(homePage.Subscription(mail),"You have been successfully subscribed!");


    }
}
