package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class P04_TestCasePage {
    private final WebDriver driver;


    private By TestCasesBtn = By.cssSelector("a[href='/test_cases']");

    public P04_TestCasePage(WebDriver driver) {
        super();
        this.driver = driver;
    }


    public void NavigateToTestCasesPage() {
        Utility.ClickingOnElement(driver, TestCasesBtn);
    }

}
