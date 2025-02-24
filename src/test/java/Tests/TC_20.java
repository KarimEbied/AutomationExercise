package Tests;

import Pages.P05_ProductsPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_20 extends BaseTest{
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String pass = DataUtils.getJsonData("validLogin", "pass");
    private final String product = DataUtils.getJsonData("validLogin", "Blue Top");


    @Test
            public void SearchProductsAndVerifyCartAfterLogin(){
        P05_ProductsPage productsPage = new P05_ProductsPage(getDriver());
        productsPage.NavigateToProductsPage();
        Assert.assertEquals("https://automationexercise.com/products",getDriver().getCurrentUrl());
        productsPage.SearchProduct(product);
        Assert.assertEquals(productsPage.VerifyAllProductsRelatedToSearchAreVisible(),1);
        Assert.assertEquals(productsPage.Adding().navigateToLoginPage()
                .validLogin(mail,pass).VerifyCartAfterLogin(),"Blue Top");



    }



}
