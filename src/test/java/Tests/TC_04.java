package Tests;

import Pages.P01_RegisterPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_04 extends BaseTest{
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String pass = DataUtils.getJsonData("validLogin", "pass");
@Test
    public void LogoutUser(){
    P01_RegisterPage registerPage= new P01_RegisterPage(getDriver());
    registerPage.navigateToLoginPage();
    Assert.assertEquals("Login to your account",registerPage.VerifyLoginToYourACC());
registerPage.
        validLogin(mail,pass);
Assert.assertEquals("https://automationexercise.com/",getDriver().getCurrentUrl() );
registerPage.Logout();
Assert.assertEquals("https://automationexercise.com/login",getDriver().getCurrentUrl() );




}

}
