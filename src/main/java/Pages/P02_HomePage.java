package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class P02_HomePage  {
    private final WebDriver driver;


    private By DeleteAccBtn = By.cssSelector("a[href='/delete_account']");
    private By LoginBTN = By.cssSelector("a[href='/login']");
    private By AccDeletedMsg = By.xpath("//b");
    private By Register = By.xpath("//u");
    private By Subscription = By.cssSelector("div[class='single-widget'] h2");
    private By SubsMail = By.id("susbscribe_email");
    private By SubsBTN = By.id("subscribe");
    private By SubsMSG = By.id("success-subscribe");
    private By Quantity = By.id("quantity");
    private By AddToCart = By.xpath("//button[@type='button']");
    private By FQuantity = By.xpath("(//button[@class='disabled'])" + "[1]");
    private By viewCartBtn = By.xpath("//u");
    private By FproductDetail = By.cssSelector("a[href='/product_details/1']");
    private By Fproduct = By.xpath("(//a[@data-product-id='1'])[1]");
    private By Sproduct = By.xpath("(//a[@data-product-id='2'])[1]");
    private By ContinueShoppingBTN = By.xpath("//button[@data-dismiss='modal']");
    private By ProceedtoCheckoutBTN = By.xpath("//a[@class]");
    private By ViewCartBtn =By.cssSelector("a[href='/view_cart']");
    private By AccCreatedContinueBtn = By.xpath("//a[@data-qa]");
    private By womenCategory = By.cssSelector("a[href='#Women']");
    private By menCategory = By.cssSelector("a[href='#Men']");
    private By dressCategory = By.cssSelector("a[href='/category_products/1']");
    private By TshirtsCategory = By.cssSelector("a[href='/category_products/3']");
    private By dressMSG = By.xpath("//h2[@class]");

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
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
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, FproductDetail);
        driver.findElement(Quantity).clear();
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

    public P02_HomePage AddProductsHomePage() {
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, ContinueShoppingBTN);
        Utility.ClickingOnElement(driver, Sproduct);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }
    public P06_CartPage NavigateToCartPage(){
        Utility.ClickingOnElement(driver, ViewCartBtn);
        return new P06_CartPage(driver);
    }
    public P01_RegisterPage navigateToLoginPage() {
        Utility.ClickingOnElement(driver, LoginBTN);
        return new P01_RegisterPage(driver);
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
