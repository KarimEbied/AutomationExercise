package Tests;

import Pages.P05_ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_08 extends BaseTest{

    @Test
            public void AllProducts(){
        P05_ProductsPage productsPage = new P05_ProductsPage(getDriver());
        productsPage.NavigateToProductsPage();
        Assert.assertEquals("https://automationexercise.com/products",getDriver().getCurrentUrl());
        productsPage.ViewProductDetail();
        Assert.assertEquals(productsPage.VerifyProductDetail(),"Condition:");


    }



}
