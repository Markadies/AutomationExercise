package com.automationexercise.pages;

import com.automationexercise.components.AddToCartModalComponent;
import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private WebDriver driver;
    private AddToCartModalComponent addToCartModalComponent;
    private By productInfo = By.className("product-information");
    private By productName = By.xpath("//div[@class='product-information']//h2");
    private By productCategory = By.xpath("//div[@class='product-information']//p[1]");
    private By productPrice = By.xpath("//div[@class='product-information']/span/span");
    private By productAvailability = By.xpath("//div[@class='product-information']//p[2]");
    private By productCondition = By.xpath("//div[@class='product-information']//p[3]");
    private By productBrand = By.xpath("//div[@class='product-information']//p[4]");
    private By productQuantity = By.id("quantity");
    private By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");
    private By writeYourReviewText = By.xpath("//li[@class='active']/a");
    private By nameInput = By.id("name");
    private By emailInput = By.id("email");
    private By reviewInput = By.id("review");
    private By submitReviewButton = By.id("button-review");
    private By sucessfulReviewMessage = By.xpath("//span[contains(text(),'Thank you')]");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.addToCartModalComponent = new AddToCartModalComponent(driver);
    }

    public AddToCartModalComponent getAddToCartModalComponent() {
        return addToCartModalComponent;
    }


    public String getProductName() {
        return ElementAction.getText(driver, productName);
    }
    public String getProductCategory() {
        return ElementAction.getText(driver, productCategory);
    }
    public String getProductPrice() {
        return ElementAction.getText(driver, productPrice);
    }
    public String getProductAvailability() {
        return ElementAction.getText(driver, productAvailability);
    }
    public String getProductCondition() {
        return ElementAction.getText(driver, productCondition);
    }
    public String getProductBrand() {
        return ElementAction.getText(driver, productBrand);
    }
    public String getProductQuantity() {
        return ElementAction.getAttribute(driver, productQuantity, "value");
    }
    public void setProductQuantity(String quantity) {
        ElementAction.sendData(driver, productQuantity, quantity);
    }

    public void clickAddToCartButton() {
        ElementAction.clickElement(driver, addToCartButton);
    }

    public CartPage modalClickViewCart(){
        return addToCartModalComponent.clickViewCartButton();
    }

    public void modalClickContinueShoppingButton(){
        addToCartModalComponent.clickContinueShoppingButton();
    }

    public boolean isProductInfoVisible() {

        return ElementAction.isVisible(driver, productInfo) &&
                ElementAction.isVisible(driver, productName) &&
                ElementAction.isVisible(driver, productAvailability) &&
                ElementAction.isVisible(driver, productCondition) &&
                ElementAction.isVisible(driver, productBrand) &&
                ElementAction.isVisible(driver, productCategory) &&
                ElementAction.isVisible(driver, productPrice);
    }

    public String getWriteYourReviewText() {
        return ElementAction.getText(driver, writeYourReviewText);
    }

    public void enterReviewData(String name, String email, String ReviewText){
        ElementAction.sendData(driver,nameInput,name);
        ElementAction.sendData(driver,emailInput,email);
        ElementAction.sendData(driver,reviewInput,ReviewText);
    }
    public void clickSubmitReviewButton() {
        ElementAction.clickElement(driver, submitReviewButton);
    }

    public boolean isSucessfulReviewMessageVisible() {
        return ElementAction.isVisible(driver, sucessfulReviewMessage);
    }


}
