package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class P06_CartPage {
    private final WebDriver driver;


    private By CartBTN =By.cssSelector("a[href='/view_cart']");
    private By PaymentBTN = By.cssSelector("a[href='/payment']");
    private By CartEmptyMSG = By.xpath("//b");
    private By Subscription = By.cssSelector("div[class='single-widget'] h2");
    private By SubsMail = By.id("susbscribe_email");
    private By SubsBTN = By.id("subscribe");
    private By SubsMSG = By.id("success-subscribe");
    private By ProceedtoCheckoutBTN = By.xpath("//a[@class]");
    private By CommentBox = By.xpath("//textarea[@class='form-control']");
    private By NameOnCard = By.xpath("//input[@class='form-control']");
    private By CardNumber = By.xpath("//input[@name='card_number']");
    private By CVC = By.xpath("//input[@name='cvc']");
    private By EXP = By.xpath("//input[@name='expiry_month']");
    private By YY = By.xpath("//input[@name='expiry_year']");
    private By payAndConfirmBtn = By.id("submit");
    private By orderMsg = By.xpath("(//b)" + "[2]");
    private By ContinuBtn = By.xpath("//a[@data-qa='continue-button']");
    private By viewCartBtn = By.xpath("//u");
    private By Fproduct = By.xpath("(//a[@data-product-id='1'])" + "[1]");
    private By RemoveBTN = By.xpath("//a[@style='cursor: pointer;']");
    private By DeliveryAdd = By.xpath("//*[@id=\"address_delivery\"]/li[5]");
    private By LoginBTN = By.cssSelector("a[href='/login']");

    public P06_CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public P01_RegisterPage navigateToLoginPage() {
        Utility.ClickingOnElement(driver, LoginBTN);
        return new P01_RegisterPage(driver);
    }


    public String VerifySubscription() {
        Utility.ClickingOnElement(driver, CartBTN);
        return Utility.getText(driver, Subscription);
    }

    public String Subscription(String mail) {
        Utility.SendData(driver, SubsMail, mail);
        Utility.ClickingOnElement(driver, SubsBTN);
        return Utility.getText(driver, SubsMSG);
    }




    public P02_HomePage orderPlaced() {
        Utility.ClickingOnElement(driver, ContinuBtn);
        return new P02_HomePage(driver);
    }

    public String Checkout(String comment, String name, String cardNumber, String cvc, String exp, String yy) {
        Utility.ClickingOnElement(driver, ProceedtoCheckoutBTN);
        Utility.SendData(driver, CommentBox, comment);
        Utility.ClickingOnElement(driver, PaymentBTN);
        Utility.SendData(driver, NameOnCard, name);
        Utility.SendData(driver, CardNumber, cardNumber);
        Utility.SendData(driver, CVC, cvc);
        Utility.SendData(driver, EXP, exp);
        Utility.SendData(driver, YY, yy);
        Utility.ClickingOnElement(driver, payAndConfirmBtn);
        return Utility.getText(driver, orderMsg);
    }



    public String RemoveProductsFromCart()  {
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, viewCartBtn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Utility.ClickingOnElement(driver, RemoveBTN);
        return Utility.getText(driver, CartEmptyMSG);
    }

    public String VerifyAddress() {
        return Utility.getText(driver, DeliveryAdd);
    }


}
