package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class P03_ContactUSPage {
    private final WebDriver driver;


    @FindBy(css = "a[href='/contact_us']")
    private WebElement ContactUSBtn;
    @FindBy(css = "h2.title:nth-child(2)")
    private WebElement GetInTouchMSG;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement NameFiled;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailFiled;
    @FindBy(xpath = "//input[@name='subject']")
    private WebElement SubjectFiled;
    @FindBy(id = "message")
    private WebElement MsgHere;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement ChooseFile;
    @FindBy(xpath = "//input[@data-qa='submit-button']")
    private WebElement SubmitBtn;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement SuccessMsg;

    public P03_ContactUSPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
