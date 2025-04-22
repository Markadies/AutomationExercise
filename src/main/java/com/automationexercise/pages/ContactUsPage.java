package com.automationexercise.pages;

import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;

    private By getInTouchSign = By.xpath("//h2[text()='Get In Touch']");
    private By nameField = By.name("name");
    private By emailField = By.name("email");
    private By subjectField = By.name("subject");
    private By messageField = By.name("message");
    private By fileUploadField = By.name("upload_file");
    private By submitButton = By.name("submit");
    private By SucessfulSubmitMessage = By.xpath("//div[@class='contact-form']//div[@class='status alert alert-success']");;
    private By returnHomeButton = By.partialLinkText("Home");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean GetInTouchSign() {
        return ElementAction.isVisible(driver, getInTouchSign);
    }
    public void setNameField(String name) {
        ElementAction.sendData(driver, nameField, name);
    }
    public void setEmailField(String email) {
        ElementAction.sendData(driver, emailField, email);
    }
    public void setSubjectField(String subject) {
        ElementAction.sendData(driver, subjectField, subject);
    }
    public void setMessageField(String message) {
        ElementAction.sendData(driver, messageField, message);
    }
    public void setFileUploadField(String fileURL) {
        ElementAction.sendData(driver, fileUploadField, fileURL);
    }
    public void clickSubmit() {
        ElementAction.clickElement(driver, submitButton);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
    }

    public String getSucessfulSubmitMessage() {
        return ElementAction.getText(driver, SucessfulSubmitMessage);
    }

    public boolean isSucessfulSubmitMessageVisible() {
        return ElementAction.isVisible(driver, SucessfulSubmitMessage);
    }

    public HomePage clickReturnHomeButton() {
        ElementAction.clickElement(driver, returnHomeButton);
        return new HomePage(driver);
    }

}
