package Tests;


import Pages.P03_ContactUSPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_06 extends BaseTest{
    private final String Name = DataUtils.getJsonData("validLogin", "Name");
    private final String mail = DataUtils.getJsonData("validLogin", "Email Add");
    private final String subject = DataUtils.getJsonData("validLogin", "Subject");
    private final String msg = DataUtils.getJsonData("validLogin", "MSG");
    private final String path = DataUtils.getJsonData("validLogin", "path");

    @Test
            public void ContactUS(){
        P03_ContactUSPage contactUSPage = new P03_ContactUSPage(getDriver());
        contactUSPage.NavigateToContactUSPage();
        Assert.assertEquals("GET IN TOUCH",contactUSPage.VerifyContactUsPage());
        contactUSPage.FillingInfoContactPage(Name,mail,subject,msg,path);
        Assert.assertEquals("Success! Your details have been submitted successfully.",contactUSPage.VerifySuccessMsg());


    }



}
