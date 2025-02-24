package Tests;

import Pages.P05_ProductsPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_21 extends BaseTest{
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String name = DataUtils.getJsonData("validLogin", "Name");
    private final String review = DataUtils.getJsonData("validLogin", "review");


    @Test
            public void AddReviewOnProduct(){
        P05_ProductsPage productsPage = new P05_ProductsPage(getDriver());
        productsPage.NavigateToProductsPage();
        Assert.assertEquals(productsPage.ReviewProduct(name,mail,review),"Thank you for your review.");



    }



}
