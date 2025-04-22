package com.automationexercise.test.base;

import com.automationexercise.drivers.DriverManager;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.BrowserAction;
import com.automationexercise.utils.JsonUtils;
import com.automationexercise.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;


public class BaseTests {
    //setUp
    private WebDriver driver;
    protected HomePage homePage;
    protected JsonUtils testData;

    @BeforeSuite
    public void beforeSuite() {
        // Load properties
        PropertiesUtils.loadProperties();
        testData = new JsonUtils("testdata");
    }

    @BeforeMethod
    public void setUp(){
        driver = DriverManager.createInstance("chrome");
        BrowserAction.navigateToURL("https://automationexercise.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public ProductsPage navigateToProductPage(){
        homePage.checkHomePageVisible();
        var productsPage = homePage.clickProductsIcon();
        assertEquals(productsPage.getProductsPageHeaderTitle(), "ALL PRODUCTS","Navigation to Products Page failed");
        assertEquals(BrowserAction.getURL(),"https://automationexercise.com/products", "Navigation to Products Page failed");
        return productsPage;
    }

    public CartPage addProductsToCart_navigateToCartPage(String product1, String product2){
        homePage.checkHomePageVisible();
        var productPage = navigateToProductPage();
        productPage.addToCart(product1);
        productPage.modalClickContinueShoppingButton();
        productPage.addToCart(product2);
        var cart = productPage.modalClickViewCart();
        assert !cart.isCartTableBodyEmpty() : "Cart is empty";
        return cart;
    }
}
