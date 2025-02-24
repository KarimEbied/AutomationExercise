package Tests;

import Pages.P01_RegisterPage;
import Pages.P02_HomePage;
import Pages.P06_CartPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_17 extends BaseTest{
@Test
    public void RemoveProductsFromCart() throws InterruptedException {
    Assert.assertEquals(new P06_CartPage(getDriver()).RemoveProductsFromCart(),"Cart is empty!");





}
}
