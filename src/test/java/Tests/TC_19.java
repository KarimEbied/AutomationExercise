package Tests;

import Pages.P05_ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_19 extends BaseTest{
@Test
    public void ViewCartBrandProduct() throws InterruptedException {
    P05_ProductsPage productsPage=new P05_ProductsPage(getDriver());
    productsPage.NavigateToProductsPage();
    Assert.assertEquals(productsPage.VerifyPoloBrand(),"https://automationexercise.com/brand_products/Polo");
    Assert.assertEquals(productsPage.VerifyNavigateToAnotherBrandMADAME(),"https://automationexercise.com/brand_products/Madame");





}
}
