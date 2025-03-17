package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class P01_RegisterPage {
    private final WebDriver driver;

    private By LoginBTN = By.cssSelector("a[href='/login']");
    private By LogoutBTN = By.cssSelector("a[href='/logout']");
    private By LoginToYourACC = By.cssSelector("div[class='login-form'] h2");
    private By NewUserSignup=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    private By ErrorMSG = By.xpath("//p[@style]");
    private By Name = By.xpath("//input[@data-qa='signup-name']");
    private By Email = By.xpath("//input[@data-qa='signup-email']");
    private By SignBtn = By.xpath("//button[@data-qa='signup-button']");
    private By MR = By.id("id_gender1");
    private By infPass = By.id("password");
    private By infDays = By.id("days");
    private By infMonths = By.id("months");
    private By infYears =By.id("years");
    private By infNewSletter =By.id("newsletter");
    private By infOffers =By.id("optin");
    private By InfFirstName = By.id("first_name");
    private By InfLastName = By.id("last_name");
    private By InfCompany = By.id("company");
    private By InfAddress1 = By.id("address1");
    private By InfAddress2 = By.id("address2");
    private By InfCountry = By.id("country");
    private By InfState = By.id("state");
    private By InfCity = By.id("city");
    private By InfZipCode = By.id("zipcode");
    private By InfMobileNumber = By.id("mobile_number");
    private By InfAccCreatedBtn = By.xpath("//button[@data-qa='create-account']");
    private By AccCreatedMsg = By.xpath("//b");
    private By AccCreatedContinueBtn = By.xpath("//a[@data-qa]");
    private By EmailAdd = By.xpath("//input[@data-qa='login-email']");
    private By LoginPass = By.xpath("//input[@data-qa='login-password']");
    private By LoginBtn = By.xpath("//button[@data-qa='login-button']");


    public P01_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    public P01_RegisterPage Signup(String name, String email) {
        Utility.SendData(driver, Name, name);
        Utility.SendData(driver, Email, email);
        Utility.ClickingOnElement(driver, SignBtn);
        return new P01_RegisterPage(driver);
    }

    public P01_RegisterPage EntetACCiNf(String pass, String day, String month, String year, String name, String Lname,
                                        String company, String Add1, String Add2, String country,
                                        String state, String city, String Zip, String mobile)  {
        Utility.ClickingOnElement(driver, MR);
        Utility.SendData(driver, infPass, pass);
        Utility.SendData(driver, infDays, day);
        Utility.selectingFromDropDown(driver, infMonths, month);
        Utility.selectingFromDropDown(driver, infYears, year);
        Utility.ClickingOnElement(driver,infNewSletter);
        Utility.ClickingOnElement(driver,infOffers);
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

    public P01_RegisterPage createACC() {
        Utility.scrollin(driver, InfAccCreatedBtn);
        Utility.ClickingOnElement(driver, InfAccCreatedBtn);
        return this;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return this;
    }

}
