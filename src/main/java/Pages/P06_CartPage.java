package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class P06_CartPage {
    private final WebDriver driver;


    @FindBy(css = "a[href='/view_cart']")
    private WebElement CartBTN;
    @FindBy(css = "a[href='/payment']")
    private WebElement PaymentBTN;
    @FindBy(xpath = "//b")
    private WebElement CartEmptyMSG;
    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement Subscription;
    @FindBy(id = "susbscribe_email")
    private WebElement SubsMail;
    @FindBy(id = "subscribe")
    private WebElement SubsBTN;
    @FindBy(id = "success-subscribe")
    private WebElement SubsMSG;
    @FindBy(xpath = "//a[@data-qa]")
    private WebElement AccCreatedContinueBtn;
    @FindBy(xpath = "//a[@class]")
    private WebElement ProceedtoCheckoutBTN;
    @FindBy(xpath = "//textarea[@class='form-control']")
    private WebElement CommentBox;
    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement NameOnCard;
    @FindBy(xpath = "//input[@name='card_number']")
    private WebElement CardNumber;
    @FindBy(xpath = "//input[@name='cvc']")
    private WebElement CVC;
    @FindBy(xpath = "//input[@name='expiry_month']")
    private WebElement EXP;
    @FindBy(xpath = "//input[@name='expiry_year']")
    private WebElement YY;
    @FindBy(id = "submit")
    private WebElement payAndConfirmBtn;
    @FindBy(xpath = "(//b)" + "[2]")
    private WebElement orderMsg;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement ContinuBtn;
    @FindBy(xpath = "//u")
    private WebElement viewCartBtn;
    @FindBy(xpath = "(//a[@data-product-id='1'])" + "[1]")
    private WebElement Fproduct;

    @FindBy(xpath = "//a[@style='cursor: pointer;']")
    private WebElement RemoveBTN;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]/li[5]")
    private WebElement DeliveryAdd;

    public P06_CartPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public String CheckoutWhileRegister(String comment, String name, String cardNumber, String cvc, String exp, String yy) {
        Utility.ClickingOnElement(driver, AccCreatedContinueBtn);
        Utility.ClickingOnElement(driver, CartBTN);
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

    public P02_HomePage orderPlaced() {
        Utility.ClickingOnElement(driver, ContinuBtn);
        return new P02_HomePage(driver);
    }

    public String CheckoutBeforeRegister(String comment, String name, String cardNumber, String cvc, String exp, String yy) {
        Utility.ClickingOnElement(driver, CartBTN);
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

    public String Checkout(String comment, String name, String cardNumber, String cvc, String exp, String yy) {
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

    public String RemoveProductsFromCart() throws InterruptedException {
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
