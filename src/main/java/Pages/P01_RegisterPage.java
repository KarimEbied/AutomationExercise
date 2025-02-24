package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class P01_RegisterPage {
    private final WebDriver driver;

    @FindBy(css = "a[href='/login']")
    private WebElement LoginBTN;
    @FindBy(css = "a[href='/logout']")
    private WebElement LogoutBTN;
    @FindBy(css = "div[class='login-form'] h2")
    private WebElement LoginToYourACC;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
    private WebElement NewUserSignup;
    @FindBy(xpath = "//p[@style]")
    private WebElement ErrorMSG;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement Name;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement Email;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement SignBtn;
    @FindBy(id = "id_gender1")
    private WebElement MR;
    @FindBy(id = "password")
    private WebElement infPass;
    @FindBy(id = "days")
    private WebElement infDays;
    @FindBy(id = "months")
    private WebElement infMonths;
    @FindBy(id = "years")
    private WebElement infYears;
    @FindBy(id = "first_name")
    private WebElement InfFirstName;
    @FindBy(id = "last_name")
    private WebElement InfLastName;
    @FindBy(id = "company")
    private WebElement InfCompany;
    @FindBy(id = "address1")
    private WebElement InfAddress1;
    @FindBy(id = "address2")
    private WebElement InfAddress2;
    @FindBy(id = "country")
    private WebElement InfCountry;
    @FindBy(id = "state")
    private WebElement InfState;
    @FindBy(id = "city")
    private WebElement InfCity;
    @FindBy(id = "zipcode")
    private WebElement InfZipCode;
    @FindBy(id = "mobile_number")
    private WebElement InfMobileNumber;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement InfAccCreatedBtn;
    @FindBy(xpath = "//b")
    private WebElement AccCreatedMsg;
    @FindBy(xpath = "//a[@data-qa]")
    private WebElement AccCreatedContinueBtn;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement EmailAdd;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement LoginPass;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement LoginBtn;


    public P01_RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public P01_RegisterPage Signup(String name, String email) {
        Utility.SendData(driver, Name, name);
        Utility.SendData(driver, Email, email);
        Utility.ClickingOnElement(driver, SignBtn);
        return new P01_RegisterPage(driver);
    }

    public P01_RegisterPage EntetACCiNf(String pass, String day, String month, String year, String name, String Lname,
                                        String company, String Add1, String Add2, String country,
                                        String state, String city, String Zip, String mobile) throws InterruptedException {
        Utility.ClickingOnElement(driver, MR);
        Utility.SendData(driver, infPass, pass);
        Utility.SendData(driver, infDays, day);
        Utility.selectingFromDropDown(driver, infMonths, month);
        Utility.selectingFromDropDown(driver, infYears, year);
        Utility.SendData(driver, InfFirstName, name);
        Utility.SendData(driver, InfLastName, Lname);
        Utility.SendData(driver, InfCompany, company);
        Utility.SendData(driver, InfAddress1, Add1);
        Utility.SendData(driver, InfAddress2, Add2);
        Utility.selectingFromDropDown(driver, InfCountry, country);
        Utility.SendData(driver, InfState, state);
        Utility.SendData(driver, InfCity, city);
        Utility.SendData(driver, InfZipCode, Zip);
        Utility.SendData(driver, InfMobileNumber, mobile);
        return this;
    }

    public void createACC() {
        Utility.scrollin(driver, InfAccCreatedBtn);
        Utility.ClickingOnElement(driver, InfAccCreatedBtn);
    }

    public String VerifyACcCreated() {
        return Utility.getText(driver, AccCreatedMsg);

    }

    public P02_HomePage ContinueACcCreated() {
        Utility.ClickingOnElement(driver, AccCreatedContinueBtn);
        return new P02_HomePage(driver);
    }

    public P02_HomePage validLogin(String mail, String pass) {
        Utility.SendData(driver, EmailAdd, mail);
        Utility.SendData(driver, LoginPass, pass);
        Utility.ClickingOnElement(driver, LoginBtn);
        return new P02_HomePage(driver);

    }

    public P01_RegisterPage navigateToLoginPage() {
        Utility.ClickingOnElement(driver, LoginBTN);
        return this;
    }

    public String VerifyNewUserSignup() {
        return Utility.getText(driver, NewUserSignup);
    }

    public String VerifyLoginToYourACC() {
        return Utility.getText(driver, LoginToYourACC);
    }

    public String VerifyUnValidLogin() {
        return Utility.getText(driver, ErrorMSG);
    }

    public P01_RegisterPage Logout() {
        Utility.ClickingOnElement(driver, LogoutBTN);
        return this;
    }

}
