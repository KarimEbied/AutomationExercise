package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})

public class BaseTest {
    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(DataUtils.getPropertyValue("environments", "Browser"));
        LogsUtils.info("Edge driver is opened");
        getDriver().navigate().to("https://automationexercise.com/");
        LogsUtils.info("Page is redirected to the URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // @AfterMethod
    public void quit() {
        quitDriver();
    }

}
