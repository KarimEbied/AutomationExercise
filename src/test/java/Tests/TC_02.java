package Tests;

import Pages.P01_RegisterPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_02 extends BaseTest{
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String pass = DataUtils.getJsonData("validLogin", "pass");
@Test
    public void EnterValidEmail(){
    P01_RegisterPage registerPage= new P01_RegisterPage(getDriver());
    registerPage.navigateToLoginPage();
    Assert.assertEquals("New User Signup!",registerPage.VerifyNewUserSignup());
registerPage.
        validLogin(mail,pass);
        //.DeleteACC();
   //Assert.assertEquals("ACCOUNT DELETED!",new P02_HomePage(getDriver()).VerifyAccDeleted());


}

}
