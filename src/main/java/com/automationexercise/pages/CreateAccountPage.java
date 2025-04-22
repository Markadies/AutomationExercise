package com.automationexercise.pages;

import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
    private WebDriver driver;
    private By accountInfoTitle = By.xpath("//b[text()='Enter Account Information']");
    private By title = By.id("id_gender1");
    private By nameInput = By.id("name");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By dateOfBirth_DAY = By.id("days");
    private By dateOfBirth_MONTH = By.id("months");
    private By dateOfBirth_YEAR = By.id("years");
    private By checkBox1 = By.id("newsletter");
    private By checkBox2 = By.id("optin");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By address1Input = By.id("address1");
    private By address2Input = By.id("address2");
    private By countryInput = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[text()='Create Account']");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions on Elements
    public void setTitle() {
        ElementAction.clickElement(driver, title);
    }

    public void enterNewAccountName(String newAccountname) {
        if(ElementAction.findElement(driver, nameInput).getText() != null) {
            ElementAction.findElement(driver, nameInput).clear();
        };
        ElementAction.sendData(driver, nameInput, newAccountname);
    }

    public void enterNewAccountPassword(String newAccountpassword) {
        ElementAction.sendData(driver, passwordInput, newAccountpassword);
    }


    public void selectBirthDay(String day, String month, String year) {
        selectFromBirthDAY_DropDown(day);
        selectFromBirthMONTH_DropDown(month);
        selectFromBirthYEAR_DropDown(year);
    }

    public void clickCheckBox_SignUpForNewsletter() {
        ElementAction.clickElement(driver, checkBox1);
    }

    public void clickCheckBox_ReceiveSpecialOffer() {
        ElementAction.clickElement(driver, checkBox2);
    }
    public void enterFirstName(String firstName) {
        ElementAction.sendData(driver, firstNameInput, firstName);
    }
    public void enterLastName(String lastName) {
        ElementAction.sendData(driver, lastNameInput, lastName);
    }
    public void enterCompanyName(String companyName) {
        ElementAction.sendData(driver, companyInput, companyName);
    }
    public void enterAddress1(String address1) {
        ElementAction.sendData(driver, address1Input, address1);
    }
    public void enterAddress2(String address2) {
        ElementAction.sendData(driver, address2Input, address2);
    }
    public void enterCountry(String country) {
        ElementAction.findDropDownElement(driver,countryInput).selectByVisibleText(country);
    }
    public void enterState(String state) {
        ElementAction.sendData(driver, stateInput, state);
    }
    public void enterCity(String city) {
        ElementAction.sendData(driver, cityInput, city);
    }
    public void enterZipcode(String zipcode) {
        ElementAction.sendData(driver, zipcodeInput, zipcode);
    }
    public void enterMobileNumber(String mobileNumber) {
        ElementAction.sendData(driver, mobileNumberInput, mobileNumber);
    }
    public AccountCreation_DeletionConfirmationPage clickCreateAccountButton() {
        ElementAction.clickElement(driver, createAccountButton);
        return new AccountCreation_DeletionConfirmationPage(driver);
    }



    //GET Element Values

    public String getAccountName() {
        return ElementAction.getText(driver, nameInput);
    }
    public String getAccountPassword() {
        return ElementAction.getText(driver, passwordInput);
    }
    public String getAccountDateOfBirth_Day() {
        return ElementAction.findDropDownElement(driver,dateOfBirth_DAY).getFirstSelectedOption().getText();
    }

    public String getAccountDateOfBirth_Month() {
        return ElementAction.findDropDownElement(driver,dateOfBirth_MONTH).getFirstSelectedOption().getText();
    }
    public String getAccountDateOfBirth_Year() {
        return ElementAction.findDropDownElement(driver,dateOfBirth_YEAR).getFirstSelectedOption().getText();
    }

    public boolean isAccountInfoTitleVisible() {
        return ElementAction.isVisible(driver, accountInfoTitle);
    }

    public boolean isCheckBoxSelected_SignUpForNewsletter() {
        return ElementAction.isElementSelected(driver, checkBox1);
    }
    public boolean isCheckBox_ReceiveSpecialOffer() {
        return ElementAction.isElementSelected(driver, checkBox2);
    }

    private void selectFromBirthDAY_DropDown(String day) {
        ElementAction.findDropDownElement(driver,dateOfBirth_DAY).selectByVisibleText(day);
    }
    private void selectFromBirthMONTH_DropDown(String month) {
        ElementAction.findDropDownElement(driver,dateOfBirth_MONTH).selectByVisibleText(month);
    }
    private void selectFromBirthYEAR_DropDown(String year) {
        ElementAction.findDropDownElement(driver,dateOfBirth_YEAR).selectByVisibleText(year);
    }

}
