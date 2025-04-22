package com.automationexercise.pages;

import com.automationexercise.components.FooterComponent;
import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //elements
    By slider = By.id("slider");
    By homeIcon = By.cssSelector("#header li:nth-child(1) > a");
    By loggedInByIcon = By.cssSelector("#header li:nth-child(10) > a");
    By deleteAccountIcon = By.cssSelector("#header li:nth-child(5) > a");
    By loginIcon = By.partialLinkText("Signup / Login");
    By logOutIcon = By.partialLinkText("Logout");
    By contactUsIcon = By.partialLinkText("Contact us");
    By testCasesIcon = By.partialLinkText("Test Cases");
    By productsIcon = By.partialLinkText("Products");
    By cartIcon = By.partialLinkText("Cart");
    By apiTestingIcon = By.partialLinkText("API Testing");


    private WebDriver driver;
    private FooterComponent footer;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.footer = new FooterComponent(driver);
    }

    public void clickHomeIcon() {
        ElementAction.clickElement(driver, homeIcon);
    }

    public String checkHomeIconSelectedColor() {
        String color = ElementAction.findElement(driver, homeIcon).getCssValue("color");
        return color;
    }

    public boolean checkHomePageVisible() {
        return ElementAction.isVisible(driver, slider);
    }

    public LoginPage clickLoginIcon() {
        clickIcon(loginIcon);
        return new LoginPage(driver);
    }
    public void clickLogOutIcon() {
        clickIcon(logOutIcon);
    }
    public ContactUsPage clickContactUsIcon() {
        clickIcon(contactUsIcon);
        return new ContactUsPage(driver);
    }
    public TestCasesPage clickTestCasesIcon() {
        clickIcon(testCasesIcon);
        return new TestCasesPage(driver);
    }
    public ProductsPage clickProductsIcon() {
        clickIcon(productsIcon);
        return new ProductsPage(driver);
    }
    public CartPage clickCartIcon() {
        clickIcon(cartIcon);
        return new CartPage(driver);
    }
    public void clickApiTestingIcon() {
        clickIcon(apiTestingIcon);
    }

    public String getLogInByUserText() {
        return ElementAction.getText(driver, loggedInByIcon);
    }
    public AccountCreation_DeletionConfirmationPage clickDeleteAccountIcon() {
        ElementAction.clickElement(driver, deleteAccountIcon);
        return new AccountCreation_DeletionConfirmationPage(driver);
    }

    private void clickIcon(By icon) {
        ElementAction.clickElement(driver, icon);
    }

    public FooterComponent getFooter() {
        return footer;
    }

}
