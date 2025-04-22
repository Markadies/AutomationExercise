package com.automationexercise.test.login;

import com.automationexercise.test.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NavigateTests extends BaseTests {
    @Test
    public void testNavigateToTestCasesPage_TC7() {
        //Verify that home page is visible successfully
        homePage.checkHomePageVisible();
        //Click on 'Test Cases' button
        var testCasesPage = homePage.clickTestCasesIcon();
        //Verify user is navigated to test cases page successfully
        assertEquals(testCasesPage.getPageHeaderText(), "TEST CASES","Navigation to Test Cases Page failed");
    }

    @Test
    public void testNavigateToProductsPage() {
        homePage.checkHomePageVisible();
        var productsPage = homePage.clickProductsIcon();
        assertEquals(productsPage.getProductsPageHeaderTitle(), "ALL PRODUCTS","Navigation to Products Page failed");
    }
}
