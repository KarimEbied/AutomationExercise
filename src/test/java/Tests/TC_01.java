package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_RegisterPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class TC_01 extends BaseTest {
    private final String Name = DataUtils.getJsonData("validLogin", "Name");
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String Lname = DataUtils.getJsonData("validLogin", "Lname");
    private final String pass = DataUtils.getJsonData("validLogin", "pass");
    private final String month = DataUtils.getJsonData("validLogin", "month");
    private final String year = DataUtils.getJsonData("validLogin", "year");
    private final String day = DataUtils.getJsonData("validLogin", "day");
    private final String company = DataUtils.getJsonData("validLogin", "company");
    private final String Add1 = DataUtils.getJsonData("validLogin", "Add1");
    private final String Add2 = DataUtils.getJsonData("validLogin", "Add2");
    private final String country = DataUtils.getJsonData("validLogin", "country");
    private final String state = DataUtils.getJsonData("validLogin", "state");
    private final String city = DataUtils.getJsonData("validLogin", "city");
    private final String zip = DataUtils.getJsonData("validLogin", "Zip");
    private final String mobile = DataUtils.getJsonData("validLogin", "mobile");

    @Test
    public void validSignUp() throws InterruptedException {
        P01_RegisterPage registerPage = new P01_RegisterPage(getDriver());
        registerPage.navigateToLoginPage();
        Assert.assertEquals("New User Signup!", registerPage.VerifyNewUserSignup());
        registerPage.
                Signup(Name, mail).
                EntetACCiNf(pass, day, month, year, Name, Lname, company
                        , Add1, Add2, country, state, city, zip, mobile).
                createACC();
        Assert.assertEquals("ACCOUNT CREATED!", registerPage.VerifyACcCreated());
        //registerPage.ContinueACcCreated().DeleteACC();
        //Assert.assertEquals("ACCOUNT DELETED!",new P02_HomePage(getDriver()).VerifyAccDeleted());


    }
}
