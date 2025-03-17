package Tests;

import Pages.P01_RegisterPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_05 extends BaseTest{
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String Name = DataUtils.getJsonData("validLogin", "Name");
@Test
    public void RegisterUserWithExistingEmail(){
    P01_RegisterPage registerPage= new P01_RegisterPage(getDriver());
    registerPage.navigateToLoginPage();
    Assert.assertEquals("New User Signup!",registerPage.VerifyNewUserSignup());
registerPage.
        Signup(Name,mail);
Assert.assertEquals("Email Address already exist!",registerPage.VerifyUnValidLogin());


}

}
