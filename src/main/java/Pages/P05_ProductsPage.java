package Pages;

import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.List;

public class P05_ProductsPage {
    private final WebDriver driver;


    private By ProductsBtn = By.cssSelector("a[href='/products']");
    private By PoloBTN = By.cssSelector("a[href='/brand_products/Polo']");
    private By MadamaBTN = By.cssSelector("a[href='/brand_products/Madame']");
    private By FproductDetail = By.cssSelector("a[href='/product_details/1']");
    private By condition = By.xpath("(//b)" + "[2]");
    private By Fproduct = By.xpath("(//a[@data-product-id='1'])[1]");
    private By Sproduct = By.xpath("(//a[@data-product-id='2'])[1]");
    private By ContinueShoppingBTN = By.xpath("//button[@data-dismiss='modal']");
    private By ViewCartBtn = By.cssSelector("a[href='/view_cart']");
    private By viewCartBtn = By.xpath("//u");
    private By FproductPrice = By.xpath("(//td[@class='cart_price'])[1]");
    private By SproductPrice = By.xpath("(//td[@class='cart_price'])" + "[2]");
    private By SearchBar = By.id("search_product");
    private By SearchBTN = By.id("submit_search");
    private List<WebElement> SearcedProducts;
    private By products =By.xpath("//div[@class='single-products']");
    private By Name =By.id("name");
    private By Email = By.id("email");
    private By Review = By.id("review");
    private By SubmitBTN = By.id("button-review");
    private By reviewMsg = By.xpath("//span[@style='font-size: 20px;']");

    public P05_ProductsPage(WebDriver driver) {
        this.driver = driver;
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
        SearcedProducts=driver.findElements(products);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return SearcedProducts.size();
    }
    public P05_ProductsPage navigateToProductspage(){
        Utility.ClickingOnElement(driver, ProductsBtn);
        return this;

    }

    public P06_CartPage AddProducts() {
        Utility.scrollin(driver, Fproduct);
        Utility.ClickingOnElement(driver, Fproduct);
        Utility.ClickingOnElement(driver, ContinueShoppingBTN);
        Utility.ClickingOnElement(driver, Sproduct);
        Utility.ClickingOnElement(driver, ViewCartBtn);
        return new P06_CartPage(driver);
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
