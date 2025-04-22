package com.automationexercise.pages;

import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreation_DeletionConfirmationPage {
    private WebDriver driver;
    private By accountStatusMessage = By.xpath("//h2[@class=\"title text-center\"]/b");
    private By continueButton = By.xpath("//a[text()='Continue']");

    public AccountCreation_DeletionConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountCreatedMessage() {
        return ElementAction.getText(driver, accountStatusMessage);
    }

    public String getAccountDeletedMessage() {
        return ElementAction.getText(driver, accountStatusMessage);
    }

    public HomePage clickContinueButton() {
        ElementAction.clickElement(driver, continueButton);
        return new HomePage(driver);
    }
}
