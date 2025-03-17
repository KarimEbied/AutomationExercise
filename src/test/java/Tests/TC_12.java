package Tests;

import Pages.P05_ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

@Test
public class TC_12 extends BaseTest{

    public void AddProductsInCart(){
        P05_ProductsPage productsPage = new P05_ProductsPage(getDriver());
        productsPage.navigateToProductspage().AddProducts();
        Assert.assertEquals(productsPage.getFPrice(),500);
        Assert.assertEquals(productsPage.getSPrice(),400);
    }
}
