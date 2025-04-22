package com.automationexercise.test.login;

import com.automationexercise.pages.ProductsPage;
import com.automationexercise.test.base.BaseTests;
import com.automationexercise.utils.BrowserAction;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTests extends BaseTests {
    @Test
    public void testGotoProductPage_TC8(){

        var productsPage = navigateToProductPage();
        assertTrue(productsPage.isAllProductsListVisible(), "All products are not displayed");

        var product1 = productsPage.clickViewProduct("Blue Top");
        assertTrue(product1.isProductInfoVisible(), "Product info is not visible");
    }

    @Test
    public void testSearchProduct_TC9(){
        var productsPage = navigateToProductPage();
        productsPage.searchProduct("Dress");
        assertTrue(productsPage.verifySearchedProductsVisible("Dress"), "Searched product is not visible");
    }

    @Test
    public void testAddReviewOnProduct_TC21(){
        String product1 = "Blue Top";
        var productPage = navigateToProductPage();
        var product1_page = productPage.clickViewProduct(product1);
        assertEquals(product1_page.getWriteYourReviewText(),"WRITE YOUR REVIEW","Write Your Review is not visible");
        product1_page.enterReviewData("Mark","markemad@d7k.com","Blue Top");
        product1_page.clickSubmitReviewButton();
        assertTrue(product1_page.isSucessfulReviewMessageVisible(), "Sucessful review message is not visible");
    }
}
