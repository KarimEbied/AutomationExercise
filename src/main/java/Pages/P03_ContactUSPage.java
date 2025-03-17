package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class P03_ContactUSPage {
    private final WebDriver driver;


    private By ContactUSBtn = By.cssSelector("a[href='/contact_us']");
    private By GetInTouchMSG = By.cssSelector("h2.title:nth-child(2)");
    @FindBy(xpath = "//input[@name='name']")
    private By NameFiled = By.xpath("//input[@name='name']");
    private By emailFiled = By.xpath("//input[@name='email']");
    private By SubjectFiled = By.xpath("//input[@name='subject']");
    private By MsgHere = By.id("message");
    private By ChooseFile = By.xpath("//input[@type='file']");
    private By SubmitBtn = By.xpath("//input[@data-qa='submit-button']");
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private By SuccessMsg = By.xpath("//div[@class='status alert alert-success']");

    public P03_ContactUSPage(WebDriver driver) {
        super();
        this.driver = driver;
    }


    public void NavigateToContactUSPage() {
        Utility.ClickingOnElement(driver, ContactUSBtn);
    }

    public String VerifyContactUsPage() {
        return Utility.getText(driver, GetInTouchMSG);
    }

    public void FillingInfoContactPage(String name, String mail
            , String subject, String MSG, String path) {
        Utility.SendData(driver, NameFiled, name);
        Utility.SendData(driver, emailFiled, mail);
        Utility.SendData(driver, SubjectFiled, subject);
        Utility.SendData(driver, MsgHere, MSG);
        Utility.SendData(driver, ChooseFile, path);
        Utility.ClickingOnElement(driver, SubmitBtn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.switchTo().alert().accept();
    }

    public String VerifySuccessMsg() {
        return Utility.getText(driver, SuccessMsg);
    }


}
