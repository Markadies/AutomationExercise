package com.automationexercise.test.login;

import com.automationexercise.test.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTests extends BaseTests {
    @Test
    public void testAddProductToCart_TC12() {
        String product1 = "Printed Off Shoulder Top - White";
        String product2 = "Summer White Top";
        homePage.checkHomePageVisible();
        var productPage = navigateToProductPage();
        productPage.addToCart(product1);
        productPage.modalClickContinueShoppingButton();
        productPage.addToCart(product2);
        var cart = productPage.modalClickViewCart();
        // Verify that the cart is not empty
        assert !cart.isCartTableBodyEmpty() : "Cart is empty";
        // Verify that the product names are correct
        assertEquals(cart.getProductName(product1), product1, "Product 1 name does not match");
        assertEquals(cart.getProductName(product2), product2, "Product 2 name does not match");

        // Verify that the product prices, quantities and total prices are correct
        assertEquals(cart.getProductProperty(product1,"price"), "Rs. 315", "Product price does not match");
        assertEquals(cart.getProductProperty(product2,"price"), "Rs. 400", "Product price does not match");
        assertEquals(cart.getProductProperty(product1,"quantity"), "1", "Product quantity does not match");
        assertEquals(cart.getProductProperty(product2,"quantity"), "1", "Product quantity does not match");
        assertEquals(cart.getProductProperty(product1,"total price"), "Rs. 315", "Product total price does not match");
        assertEquals(cart.getProductProperty(product2,"total price"), "Rs. 400", "Product total price does not match");
    }

    @Test
    public void testVerifyProductQuantityInCart_TC13(){
        String product = "Blue Top";
        homePage.checkHomePageVisible();
        var productPage = navigateToProductPage();

        var product1 = productPage.clickViewProduct(product);
        assertTrue(product1.isProductInfoVisible(), "Product info is not visible");

        product1.setProductQuantity("4");
        product1.clickAddToCartButton();
        var cart = product1.modalClickViewCart();
        // Verify that the cart is not empty
        assert !cart.isCartTableBodyEmpty() : "Cart is empty";
        // Verify that the product quantity are correct
        assertEquals(cart.getProductProperty(product,"quantity"), "4", "Product quantity does not match");
    }

    @Test
    public void testAddToCartFromRecommendedItems_TC22(){
        
    }



}
