package com.automationexercise.test.login;

import com.automationexercise.components.FooterComponent;
import com.automationexercise.drivers.DriverManager;
import com.automationexercise.test.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SubscriptionTests extends BaseTests {
    @Test
    public void verifySubscriptionInHomePage_TC10(){
        homePage.checkHomePageVisible();


        assertTrue(homePage.getFooter().verifySubscribtionTitleText(),"Subscription title is not visible");
        homePage.getFooter().Subscribe("JohnDoe@exxample.com");
        assertTrue(homePage.getFooter().verifySucessfulSubscriptionMessageVisible(),"Sucessful subscription message is not visible");
    }

    @Test
    public void verifySubscriptionInCartPage_TC11(){
        homePage.checkHomePageVisible();
        var cartPage = homePage.clickCartIcon();
        cartPage.getFooter().Subscribe("JohnDoe@exxample.com");
        assertTrue(cartPage.getFooter().verifySucessfulSubscriptionMessageVisible(),"Sucessful subscription message is not visible");
    }
}
