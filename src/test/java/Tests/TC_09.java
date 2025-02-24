package Tests;

import Pages.P05_ProductsPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_09 extends BaseTest{
    private final String product = DataUtils.getJsonData("validLogin", "product");


    @Test
            public void SearchProduct(){
        P05_ProductsPage productsPage = new P05_ProductsPage(getDriver());
        productsPage.NavigateToProductsPage();
        Assert.assertEquals("https://automationexercise.com/products",getDriver().getCurrentUrl());
        productsPage.SearchProduct(product);
        Assert.assertEquals(productsPage.VerifyAllProductsRelatedToSearchAreVisible(),7);


    }



}
