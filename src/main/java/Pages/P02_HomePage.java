package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class P02_HomePage {
    private final WebDriver driver;


    @FindBy(css = "a[href='/delete_account']")
    private WebElement DeleteAccBtn;
    @FindBy(xpath = "//b")
    private WebElement AccDeletedMsg;
    @FindBy(xpath = "//u")
    private WebElement Register;
    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement Subscription;
    @FindBy(id = "susbscribe_email")
    private WebElement SubsMail;
    @FindBy(id = "subscribe")
    private WebElement SubsBTN;
    @FindBy(id = "success-subscribe")
    private WebElement SubsMSG;
    @FindBy(id = "quantity")
    private WebElement Quantity;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement AddToCart;
    @FindBy(xpath = "(//button[@class='disabled'])" + "[1]")
    private WebElement FQuantity;
    @FindBy(xpath = "//u")
    private WebElement viewCartBtn;
    @FindBy(css = "a[href='/product_details/1']")
    private WebElement FproductDetail;
    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
    private WebElement Fproduct;
    @FindBy(xpath = "(//a[@data-product-id='2'])[1]")
    private WebElement Sproduct;
    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement ContinueShoppingBTN;
    @FindBy(xpath = "//a[@class]")
    private WebElement ProceedtoCheckoutBTN;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement ViewCartBtn;
    @FindBy(xpath = "//a[@data-qa]")
    private WebElement AccCreatedContinueBtn;
    @FindBy(css = "a[href='#Women']")
    private WebElement womenCategory;
    @FindBy(css = "a[href='#Men']")
    private WebElement menCategory;
    @FindBy(css = "a[href='/category_products/1']")
    private WebElement dressCategory;
    @FindBy(css = "a[href='/category_products/3']")
    private WebElement TshirtsCategory;
    @FindBy(xpath = "//h2[@class]")
    private WebElement dressMSG;

    public P02_HomePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public P02_HomePage DeleteACC() {
        Utility.ClickingOnElement(driver, DeleteAccBtn);
        return new P02_HomePage(driver);
    }

    public String VerifyAccDeleted() {
        return Utility.getText(driver, AccDeletedMsg);
    }

    public String VerifySubscription() {
        Utility.scrollin(driver, Subscription);
        return Utility.getText(driver, Subscription);
    }

    public String Subscription(String mail) {
        Utility.SendData(driver, SubsMail, mail);
        Utility.ClickingOnElement(driver, SubsBTN);
        return Utility.getText(driver, SubsMSG);
    }

    public String VerifyProductQuantityInCart(String number) {
        Utility.ClickingOnElement(driver, FproductDetail);
        Quantity.clear();
        Utility.SendData(driver, Quantity, number);
        Utility.ClickingOnElement(driver, AddToCart);
        Utility.ClickingOnElement(driver, viewCartBtn);
        return Utility.getText(driver, FQuantity);
    }

    public P01_RegisterPage PlaceOrderWhileCheckout() {
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, ContinueShoppingBTN);
        Utility.ClickingOnElement(driver, Sproduct);
        Utility.ClickingOnElement(driver, ViewCartBtn);
        Utility.ClickingOnElement(driver, ProceedtoCheckoutBTN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Utility.ClickingOnElement(driver, Register);
        return new P01_RegisterPage(driver);

    }

    public P06_CartPage PlaceOrderBeforeCheckout() {
        Utility.ClickingOnElement(driver, AccCreatedContinueBtn);
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, ContinueShoppingBTN);
        Utility.ClickingOnElement(driver, Sproduct);
        Utility.ClickingOnElement(driver, ViewCartBtn);
        Utility.ClickingOnElement(driver, ProceedtoCheckoutBTN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return new P06_CartPage(driver);
    }

    public P06_CartPage AddProductsHomePage() {
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, ContinueShoppingBTN);
        Utility.ClickingOnElement(driver, Sproduct);
        Utility.ClickingOnElement(driver, ViewCartBtn);
        Utility.ClickingOnElement(driver, ProceedtoCheckoutBTN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return new P06_CartPage(driver);
    }

    public String VerifyWomenDressProducts() {
        Utility.ClickingOnElement(driver, womenCategory);
        Utility.ClickingOnElement(driver, dressCategory);
        return Utility.getText(driver, dressMSG);
    }

    public String VerifyNavigateToMenCategory() {
        Utility.ClickingOnElement(driver, menCategory);
        Utility.ClickingOnElement(driver, TshirtsCategory);
        return driver.getCurrentUrl();
    }

    public String VerifyCartAfterLogin() {
        Utility.ClickingOnElement(driver, ViewCartBtn);
        return Utility.getText(driver, FproductDetail);
    }

    public String AddRecommendedProduct() {
        Utility.scrollin(driver, Subscription);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, viewCartBtn);
        return Utility.getText(driver, FproductDetail);

    }


}
