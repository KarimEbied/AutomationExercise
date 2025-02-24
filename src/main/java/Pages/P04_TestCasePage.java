package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class P04_TestCasePage {
    private final WebDriver driver;


    @FindBy(css = "a[href='/test_cases']")
    private WebElement TestCasesBtn;

    public P04_TestCasePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void NavigateToTestCasesPage() {
        Utility.ClickingOnElement(driver, TestCasesBtn);
    }

}
