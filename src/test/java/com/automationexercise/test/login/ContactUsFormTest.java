package com.automationexercise.test.login;

import com.automationexercise.test.base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.*;



public class ContactUsFormTest extends BaseTests {
    @Test
    public void testContactUsForm_TC6() {
        assertEquals(homePage.checkHomeIconSelectedColor(),"rgba(255, 165, 0, 1)","Home Page is not visible");

        var contactUsPage = homePage.clickContactUsIcon();
        //Verify 'GET IN TOUCH' is visible
        assertTrue(contactUsPage.GetInTouchSign(), "Contact us is not visible");

        contactUsPage.setNameField("John Doe");
        contactUsPage.setEmailField("john.doe@example.com");
        contactUsPage.setSubjectField("Product page is great");
        contactUsPage.setMessageField("Message is great");
        contactUsPage.setFileUploadField("E:\\Software Testing\\Automation Projects\\AutomationExercise\\src\\main\\resources\\file.txt");
        contactUsPage.clickSubmit();

        contactUsPage.acceptAlert();
        // Verify success message 'Success! Your details have been submitted successfully.' is visible
        assertTrue(contactUsPage.isSucessfulSubmitMessageVisible(), "Sucessful submit message is not visible");
        assertEquals(contactUsPage.getSucessfulSubmitMessage(),"Success! Your details have been submitted successfully.","sucessful submit message format is wrong");

        //Click 'Home' button and verify that landed to home page successfully
        homePage = contactUsPage.clickReturnHomeButton();
        assertEquals(homePage.checkHomeIconSelectedColor(),"rgba(255, 165, 0, 1)","Home Page is not visible");
    }


}
