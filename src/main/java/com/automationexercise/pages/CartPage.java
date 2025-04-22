package com.automationexercise.pages;

import com.automationexercise.components.FooterComponent;
import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class CartPage {
    private WebDriver driver;
    private FooterComponent footer;
    private By cartTableBody = By.xpath("//table/tbody");
    private By cartProductName = By.xpath("//tr/td/h4/a");
    private By cartProductPrice = By.xpath("//td[3]/p");
    private By cartProductQuantity = By.xpath("//td[4]/button");
    private By cartProductTotalPrice = By.xpath("//td[5]/p");
    private By cartProductRemoveButton = By.xpath(".//a[@class='cart_quantity_delete']");
    private By proceedToCheckOutButton = By.cssSelector(".btn-default.check_out");


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.footer = new FooterComponent(driver);
    }

    public FooterComponent getFooter() {
        return footer;
    }

    public boolean isCartTableBodyEmpty() {
        WebElement tableBody = ElementAction.findElement(driver, cartTableBody);
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        return rows.isEmpty();
    }

    public String getProductName(String productName) {
        List<WebElement> productNames = ElementAction.findElements(driver, cartProductName);
        for (WebElement product : productNames) {
            if (product.getText().trim().equalsIgnoreCase(productName.trim())) {
                return ElementAction.getText(driver, product);
            }
        }
        return null;
    }

    public String getProductProperty(String productName, String property) {
        List<WebElement> productNames = ElementAction.findElements(driver, cartProductName);
        List<WebElement> productProperties = null;

        switch (property.toLowerCase()) {
            case "price":
                productProperties = ElementAction.findElements(driver, cartProductPrice);
                break;
            case "quantity":
                productProperties = ElementAction.findElements(driver, cartProductQuantity);
                break;
            case "total price":
                productProperties = ElementAction.findElements(driver, cartProductTotalPrice);
                break;
            default:
                return null; // Invalid property
        }

        if (productProperties == null || productNames.size() != productProperties.size()) {
            return null; // Mismatch in list sizes or null properties
        }

        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                return ElementAction.getText(driver, productProperties.get(i));
            }
        }
        return null; // Product name not found
    }


    public void clickRemoveButton(String productName){
        List<WebElement> products = ElementAction.findElements(driver, cartProductName);
        List<WebElement> removeButtons = ElementAction.findElements(driver, cartProductRemoveButton);
        for(int i =0;i<products.size();i++){
            if(products.get(i).getText().equalsIgnoreCase(productName)){
                var check = ElementAction.isElementVisible(driver, removeButtons.get(i));
                System.out.println(check);
                ElementAction.hover(driver, removeButtons.get(i));
                ElementAction.clickElement(driver, removeButtons.get(i));
            }
        }

    }

    public void clickProceedToCheckOutButton() {
        ElementAction.clickElement(driver, proceedToCheckOutButton);
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> productElements = driver.findElements(cartProductName);
        for (WebElement product : productElements) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

}
