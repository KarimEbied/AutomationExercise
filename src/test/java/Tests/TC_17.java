package Tests;

import Pages.P06_CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_17 extends BaseTest{
@Test
    public void RemoveProductsFromCart() throws InterruptedException {
    Assert.assertEquals(new P06_CartPage(getDriver()).RemoveProductsFromCart(),"Cart is empty!");





}
}
