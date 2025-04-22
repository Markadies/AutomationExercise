package com.automationexercise.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ElementAction {
    private WebDriver driver;
    public ElementAction(WebDriver driver) {
        this.driver = driver;
    }

    public static WebElement findElement(WebDriver driver,By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }

    public static void clickElement(WebDriver driver,By locator) {
        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        driver.findElement(locator).click();
    }

    public static void sendData(WebDriver driver,By locator,String data){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        ElementAction.findElement(driver,locator).clear();
        ElementAction.findElement(driver,locator).sendKeys(data);
    }

    public static boolean isVisible(WebDriver driver,By locator){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return ElementAction.findElement(driver,locator).isDisplayed();
    }


    public static String getText(WebDriver driver,By locator){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return ElementAction.findElement(driver,locator).getText();
    }

    public static String getAttribute(WebDriver driver,By locator,String attribute){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return ElementAction.findElement(driver,locator).getAttribute(attribute);
    }

    public static boolean isElementSelected(WebDriver driver,By locator){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return ElementAction.findElement(driver,locator).isSelected();
    }

    public static Select findDropDownElement(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return new Select(ElementAction.findElement(driver, locator));
    }

    public static void hover(WebDriver driver,WebElement element) {
        Waits.waitForElementVisible(driver, element);
        Scrolling.scrollToElement(driver, element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    //function to check the list of elements is visible or not
    public static boolean isListOfElementsVisible(WebDriver driver, By locator) {
        List<WebElement> elements = findElements(driver, locator);
        for (WebElement element : elements) {
            Waits.waitForElementVisible(driver, element);
            Scrolling.scrollToElement(driver, element);
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public static WebElement getElementFromList(WebDriver driver, By listLocator, String productName) {
        List<WebElement> elements = findElements(driver, listLocator);
        for (WebElement element : elements) {
            Scrolling.scrollToElement(driver, element);
            Waits.waitForElementVisible(driver, element);
            if (element.getText().contains(productName)) {
                return element;
            }
        }
        System.out.println("Product not found: " + productName);
        return null;
    }

    public static List<WebElement> getElementsFromList(WebDriver driver, By listLocator, String productName) {
        List<WebElement> elements = findElements(driver, listLocator);
        List<WebElement> filteredElements = new ArrayList<WebElement>();
        for (WebElement element : elements) {
            Scrolling.scrollToElement(driver, element);
            Waits.waitForElementVisible(driver, element);
            if (element.getText().contains(productName)) {
                filteredElements.add(element);
            }
        }
        return filteredElements;
    }

    public static void clickElement(WebDriver driver, WebElement element) {
        Waits.waitForElementClickable(driver, element);
        Scrolling.scrollToElement(driver, element);
        element.click();
    }

    public static boolean isElementVisible(WebDriver driver, WebElement product) {
        Waits.waitForElementVisible(driver, product);
        Scrolling.scrollToElement(driver, product);
        return product.isDisplayed();
    }

    public WebElement WaitAndScrollForElement(WebDriver driver, WebElement element) {
        Waits.waitForElementVisible(driver, element);
        Scrolling.scrollToElement(driver, element);
        return element;
    }

    public static String getText(WebDriver driver, WebElement element) {
        Waits.waitForElementVisible(driver, element);
        Scrolling.scrollToElement(driver, element);
        return element.getText();
    }


}
