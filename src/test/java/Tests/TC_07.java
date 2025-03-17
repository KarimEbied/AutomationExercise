package Tests;

import Pages.P04_TestCasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC_07 extends BaseTest{

    @Test
            public void TestCases(){
        P04_TestCasePage testCasePage = new P04_TestCasePage(getDriver());
        testCasePage.NavigateToTestCasesPage();
        Assert.assertEquals("https://automationexercise.com/test_cases",getDriver().getCurrentUrl());


    }



}
