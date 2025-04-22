package com.automationexercise.components;

import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterComponent {
    private WebDriver driver;
    private By subscribtionTitle = By.xpath("//h2[text()='Subscription']");
    private By subscribtionEmail = By.id("susbscribe_email");
    private By subscribeButton = By.id("subscribe");
    private By successfulSubscriptionMessage = By.cssSelector(".alert-success.alert");


    public FooterComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void Subscribe(String email) {
        enterSubscriptionEmail(email);
        clickSubscribeButton();
    }
    public boolean verifySubscribtionTitleText(){
        if(ElementAction.isVisible(driver, subscribtionTitle)){
            return true;
        }
        return false;
    }

    public boolean verifySucessfulSubscriptionMessageVisible() {
        return ElementAction.isVisible(driver, successfulSubscriptionMessage);
    }

    private void enterSubscriptionEmail(String email) {
        ElementAction.sendData(driver, subscribtionEmail, email);
    }

    private void clickSubscribeButton() {
        ElementAction.findElement(driver, subscribeButton).click();
    }

}
