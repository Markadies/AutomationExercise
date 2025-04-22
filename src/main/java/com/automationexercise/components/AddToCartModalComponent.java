package com.automationexercise.components;

import com.automationexercise.pages.CartPage;
import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartModalComponent {
    private WebDriver driver;
    private By modalTitle = By.xpath("//h2[contains(text(),'Product added')]");
    private By continueShoppingButton = By.xpath("//button[@data-dismiss='modal']");
    private By viewCartButton = By.partialLinkText("View Cart");

    public AddToCartModalComponent(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isModalVisible() {
        return ElementAction.isVisible(driver, modalTitle);
    }

    public void clickContinueShoppingButton() {
        ElementAction.clickElement(driver, continueShoppingButton);
    }

    public CartPage clickViewCartButton() {
        ElementAction.clickElement(driver, viewCartButton);
        return new CartPage(driver);
    }
}
