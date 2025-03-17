package Tests;

import Pages.P02_HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_18 extends BaseTest{
@Test
    public void ViewCategoryProducts() throws InterruptedException {
    P02_HomePage homePage=new P02_HomePage(getDriver());
    Assert.assertEquals(homePage.VerifyWomenDressProducts(),"WOMEN - DRESS PRODUCTS");
    Assert.assertEquals(homePage.VerifyNavigateToMenCategory(),"https://automationexercise.com/category_products/3");





}
}
