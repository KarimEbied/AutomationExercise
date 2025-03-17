package Tests;

import Pages.P02_HomePage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_22 extends BaseTest{
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String name = DataUtils.getJsonData("validLogin", "Name");
    private final String review = DataUtils.getJsonData("validLogin", "review");


    @Test
            public void AddToCartFromRecommendedItems() throws InterruptedException {
        P02_HomePage homePage = new P02_HomePage(getDriver());
        Assert.assertEquals(homePage.AddRecommendedProduct(),"Blue Top");


    }



}
