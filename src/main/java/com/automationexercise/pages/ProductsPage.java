package com.automationexercise.pages;

import com.automationexercise.components.AddToCartModalComponent;
import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private AddToCartModalComponent addToCartModalComponent;
    private By allProductsHeaderTitle = By.className("title");
    private By productsList = By.xpath("//div[@class = 'features_items']//div[@class='col-sm-4']");
    private By addToCartAfterHoverButton = By.xpath(".//a[@class='btn btn-default add-to-cart']");
    private By viewProductButton = By.partialLinkText("View Product");
    private By searchProductBar = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searrchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
    private By modalViewCartLink = By.partialLinkText("View Cart");
    private By modalContinueShoppingButton = By.xpath("//button[@data-dismiss='modal']");
    private By productName = By.xpath("//div[@class='productinfo text-center']//p");
    private By productPrice = By.xpath("//div[@class='productinfo text-center']//h2");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.addToCartModalComponent = new AddToCartModalComponent(driver);
    }

    public AddToCartModalComponent getAddToCartModalComponent() {
        return addToCartModalComponent;
    }

    //Actions on Elements

    public ProductDetailsPage clickViewProduct(String productName){
        getProduct(productName).findElement(viewProductButton).click();
        return new ProductDetailsPage(driver);
    }

    public void addToCart(String productName) {
        // Locate the product element from the list
        WebElement product = ElementAction.getElementFromList(driver, productsList, productName);

        if (product == null) {
            throw new IllegalArgumentException("Product with name \"" + productName + "\" not found in the product list.");
        }

        // Hover over the product to reveal the "Add to Cart" button
        ElementAction.hover(driver, product);

        // Locate the "Add to Cart" button within the product element
        WebElement addToCartButton = product.findElement(addToCartAfterHoverButton);

        if (addToCartButton == null || !addToCartButton.isDisplayed()) {
            throw new IllegalStateException("Add to Cart button is not visible for product: " + productName);
        }

        // Click the "Add to Cart" button
        ElementAction.clickElement(driver, addToCartButton);
    }

    public void searchProduct(String productName){
        ElementAction.sendData(driver, searchProductBar, productName);
        ElementAction.clickElement(driver, searchButton);
    }

    public void hoverOverProduct(String productName){
        var product = ElementAction.getElementFromList(driver, productsList, productName);
        ElementAction.hover(driver,product);
    }

    public CartPage modalClickViewCart(){
        return addToCartModalComponent.clickViewCartButton();
    }

    public void modalClickContinueShoppingButton(){
        addToCartModalComponent.clickContinueShoppingButton();
    }

    public String getProductName(String productID){
        return ElementAction.getText(driver, productName);
    }


    public boolean verifySearchedProductsVisible(String productName){
        List<WebElement> searchedProducts = ElementAction.findElements(driver, productsList);
        for (WebElement product : searchedProducts) {
            System.out.println(product.getText());
        }
       return ElementAction.isListOfElementsVisible(driver, productsList);
    }


    public String getProductsPageHeaderTitle() {
        return ElementAction.getText(driver, allProductsHeaderTitle);
    }

    public List<WebElement> getProductsList() {
        return ElementAction.findElements(driver, productsList);
    }

    public boolean isAllProductsListVisible() {
        return ElementAction.isListOfElementsVisible(driver, productsList);
    }

    public boolean isProductVisible(String productName) {
        return ElementAction.isElementVisible(driver, getProduct(productName));
    }

    public WebElement getProduct(String productName){
       return ElementAction.getElementFromList(driver,productsList,productName);
    }

}
