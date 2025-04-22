package com.automationexercise.test.login;

import com.automationexercise.test.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PlaceOrderTest extends BaseTests {
    @Test
    public void testPlaceOrder_RegisterWhileCheckout(){
        assertTrue(homePage.checkHomePageVisible(),"HomePage is not visible");
    }
}
