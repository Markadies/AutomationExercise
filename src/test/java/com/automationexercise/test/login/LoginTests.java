package com.automationexercise.test.login;

import com.automationexercise.test.base.BaseTests;
import org.testng.annotations.Test;

import static com.automationexercise.utils.PropertiesUtils.getPropertyValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    @Test
    public void testRegisterUser_TC1() {

        String newAccountName = "John Doe";
        // Use a valid email format
        String newEmailAddress = "johnnnnDoe@example.com";
        String newAccountPassword = "password123";
        int day = 15;
        String month = "May";
        int year = 1990;

       

        var loginPage = homePage.clickLoginIcon();
        loginPage.enterSignUpEmail(newEmailAddress);
        loginPage.enterSignUpName(newAccountName);
        var createAccountPage = loginPage.clickSignUpButton();

       // assertTrue(createAccountPage.isAccountInfoTitleVisible(), "Account Info title is not visible");
        // Enter new account information
        createAccountPage.enterNewAccountName(newAccountName);
        createAccountPage.enterNewAccountPassword(newAccountPassword);
        createAccountPage.selectBirthDay(String.valueOf(day), month, String.valueOf(year));
        createAccountPage.clickCheckBox_SignUpForNewsletter();
        createAccountPage.clickCheckBox_ReceiveSpecialOffer();
        createAccountPage.enterFirstName("John");
        createAccountPage.enterLastName("Doe");
        createAccountPage.enterCompanyName("Example Company");
        createAccountPage.enterAddress1("123 Main St");
        createAccountPage.enterAddress2("Apt 4B");
        createAccountPage.enterCountry("United States");
        createAccountPage.enterState("California");
        createAccountPage.enterCity("Los Angeles");
        createAccountPage.enterZipcode("90001");
        createAccountPage.enterMobileNumber("1234567890");
        var sucessfulAccountCreation = createAccountPage.clickCreateAccountButton();
        // Verify successful account creation
        assertEquals(sucessfulAccountCreation.getAccountCreatedMessage(), "ACCOUNT CREATED!", "Account creation message is not displayed");

        homePage = sucessfulAccountCreation.clickContinueButton();
        //Verify That user is registered and logged in successfully
        assertEquals(homePage.getLogInByUserText(), "Logged in as John Doe", "User is not logged in");

        var deleteAccountConfirmation = homePage.clickDeleteAccountIcon();
        assertEquals(deleteAccountConfirmation.getAccountDeletedMessage(), "ACCOUNT DELETED!", "Account deletion message is not displayed");


        homePage = deleteAccountConfirmation.clickContinueButton();
    }
    @Test
    public void testLoginSucessfully_TC2() {
        homePage.clickHomeIcon();
        //comparing the color, if orange then the page is visible


        var loginPage = homePage.clickLoginIcon();

        loginPage.enterLoginEmail("johnDoe@example.com");
        loginPage.enterLoginPassword("password123");
        homePage = loginPage.clickLoginButton();
        assertEquals(homePage.getLogInByUserText(),"Logged in as John Doe");

        var deleteAccountMessagePage = homePage.clickDeleteAccountIcon();
        assertEquals(deleteAccountMessagePage.getAccountDeletedMessage(),"ACCOUNT DELETED!","Account deletion message is not displayed");
    }

    @Test
    public void testLoginFailed_TC3() {
        assertEquals(homePage.checkHomeIconSelectedColor(),"rgba(255, 165, 0, 1)","Home Page is not visible");

        var loginPage = homePage.clickLoginIcon();
        loginPage.enterLoginEmail("DoeJohn@gmail.com");
        loginPage.enterLoginPassword("Doe123");
        loginPage.clickLoginButton();

        assertTrue(loginPage.isLoginErrorMessageVisible(),"Login Failed message is not visible");

    }

    @Test
    public void testLogout_TC4() {
        assertEquals(homePage.checkHomeIconSelectedColor(),"rgba(255, 165, 0, 1)","Home Page is not visible");
        var login = homePage.clickLoginIcon();
        login.enterLoginEmail("johnnnDoe@example.com");
        login.enterLoginPassword("password123");
        login.clickLoginButton();
        assertEquals(homePage.getLogInByUserText(),"Logged in as John Doe");
        homePage.clickLogOutIcon();
        assertEquals(homePage.checkHomeIconSelectedColor(),"rgba(255, 165, 0, 1)","Home Page is not visible after logout");
    }

    @Test
    public void testRegisterUserWithExistingEmail_TC5() {
        assertEquals(homePage.checkHomeIconSelectedColor(),"rgba(255, 165, 0, 1)","Home Page is not visible");
        var signUpPage = homePage.clickLoginIcon();
        signUpPage.enterSignUpName("John Doe");
        signUpPage.enterSignUpEmail("johndoe@example.com");
        signUpPage.clickSignUpButton();
        assertTrue(signUpPage.isAlreadyExistsMessageVisible(),"Email entered to Signup already existed");
    }

    @Test
    public void testPlaceOrder_RegisterWhileCheckOut_TC14(){
        homePage.checkHomePageVisible();
        var productPage = navigateToProductPage();
        String product1 = "Printed Off Shoulder Top - White";
        String product2 = "Blue Top";

        productPage.addToCart(product1);
        productPage.modalClickContinueShoppingButton();
        productPage.addToCart(product2);
        var cart = productPage.modalClickViewCart();
        // Verify that the cart is not empty
        assert !cart.isCartTableBodyEmpty() : "Cart is empty";

    }





}
