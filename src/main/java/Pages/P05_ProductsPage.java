package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P05_ProductsPage {
    private final WebDriver driver;


    @FindBy(css = "a[href='/products']")
    private WebElement ProductsBtn;
    @FindBy(css = "a[href='/brand_products/Polo']")
    private WebElement PoloBTN;
    @FindBy(css = "a[href='/brand_products/Madame']")
    private WebElement MadamaBTN;
    @FindBy(css = "a[href='/product_details/1']")
    private WebElement FproductDetail;
    @FindBy(xpath = "(//b)" + "[2]")
    private WebElement condition;
    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
    private WebElement Fproduct;
    @FindBy(xpath = "(//a[@data-product-id='2'])[1]")
    private WebElement Sproduct;
    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement ContinueShoppingBTN;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement ViewCartBtn;
    @FindBy(xpath = "//u")
    private WebElement viewCartBtn;
    @FindBy(xpath = "(//td[@class='cart_price'])[1]")
    private WebElement FproductPrice;
    @FindBy(xpath = "(//td[@class='cart_price'])" + "[2]")
    private WebElement SproductPrice;
    @FindBy(id = "search_product")
    private WebElement SearchBar;
    @FindBy(id = "submit_search")
    private WebElement SearchBTN;
    @FindBy(xpath = "//div[@class='single-products']")
    private
    List<WebElement> products;
    @FindBy(id = "name")
    private WebElement Name;
    @FindBy(id = "email")
    private WebElement Email;
    @FindBy(id = "review")
    private WebElement Review;
    @FindBy(id = "button-review")
    private WebElement SubmitBTN;
    @FindBy(xpath = "//span[@style='font-size: 20px;']")
    private WebElement reviewMsg;

    public P05_ProductsPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void NavigateToProductsPage() {
        Utility.ClickingOnElement(driver, ProductsBtn);
    }

    public void ViewProductDetail() {
        Utility.scrollin(driver, FproductDetail);
        Utility.ClickingOnElement(driver, FproductDetail);
    }

    public String VerifyProductDetail() {
        return Utility.getText(driver, condition);
    }

    public void SearchProduct(String product) {
        Utility.SendData(driver, SearchBar, product);
        Utility.ClickingOnElement(driver, SearchBTN);
    }

    public int VerifyAllProductsRelatedToSearchAreVisible() {
        return products.size();
    }

    public void AddProducts() {
        Utility.ClickingOnElement(driver, ProductsBtn);
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, ContinueShoppingBTN);
        Utility.ClickingOnElement(driver, Sproduct);
        Utility.ClickingOnElement(driver, ViewCartBtn);
    }

    public int getFPrice() {
        String fproductPrice = Utility.getText(driver, FproductPrice);
        int Fprice = Integer.parseInt(fproductPrice.replace("Rs.", "").trim());
        return Fprice;
    }

    public int getSPrice() {
        String SPrice = Utility.getText(driver, SproductPrice);
        int Sprice = Integer.parseInt(SPrice.replace("Rs.", "").trim());
        return Sprice;
    }

    public String VerifyPoloBrand() {
        Utility.ClickingOnElement(driver, PoloBTN);
        return driver.getCurrentUrl();
    }

    public String VerifyNavigateToAnotherBrandMADAME() {
        Utility.ClickingOnElement(driver, MadamaBTN);
        return driver.getCurrentUrl();


    }

    public P01_RegisterPage Adding() {
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, viewCartBtn);
        return new P01_RegisterPage(driver);
    }

    public String ReviewProduct(String name, String mail, String review) {
        Utility.ClickingOnElement(driver, FproductDetail);
        Utility.SendData(driver, Name, name);
        Utility.SendData(driver, Email, mail);
        Utility.SendData(driver, Review, review);
        Utility.ClickingOnElement(driver, SubmitBTN);
        return Utility.getText(driver, reviewMsg);
    }


}
