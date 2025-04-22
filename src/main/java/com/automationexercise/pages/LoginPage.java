package com.automationexercise.pages;

import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By newUserSignUp = By.cssSelector(".signup-form h2");
    private By signUpName = By.cssSelector("input[data-qa=\"signup-name\"]");
    private By signUpEmail = By.cssSelector("input[data-qa=\"signup-email\"]");
    private By signUpButton = By.cssSelector("button[data-qa=\"signup-button\"]");
    private By loginEmail = By.xpath("//form[@action = '/login']/input[@type= 'email']");
    private By loginPassword = By.xpath("//form[@action = '/login']/input[@type= 'password']");
    private By loginButton = By.xpath("//form[@action = '/login']/button");
    private By loginFailedMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
    private By signUpEmailAlreadyExistsMessage = By.xpath("//p[text()='Email Address already exist!']");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSignUpName(String userName) {
        ElementAction.sendData(driver, signUpName, userName);
    }
    public void enterSignUpEmail(String userEmail) {
        ElementAction.sendData(driver, signUpEmail, userEmail);
    }

    public CreateAccountPage clickSignUpButton() {
        ElementAction.clickElement(driver, signUpButton);
        return new CreateAccountPage(driver);
    }

    public void enterLoginEmail(String email) {
        ElementAction.sendData(driver, loginEmail, email);
    }
    public void enterLoginPassword(String password) {
        ElementAction.sendData(driver, loginPassword, password);
    }
    public HomePage clickLoginButton() {
        ElementAction.clickElement(driver, loginButton);
        return new HomePage(driver);
    }

    public boolean isUserSignUpVisible() {
        return ElementAction.isVisible(driver, newUserSignUp);
    }

    public boolean isLoginErrorMessageVisible() {
        return ElementAction.isVisible(driver,loginFailedMessage);
    }

    public boolean isAlreadyExistsMessageVisible(){
        return ElementAction.isVisible(driver,signUpEmailAlreadyExistsMessage);
    }




}
