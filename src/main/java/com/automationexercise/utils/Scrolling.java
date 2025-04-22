package com.automationexercise.utils;

import org.openqa.selenium.*;

public class Scrolling {
    //private constructor
    private Scrolling(){
    }

    public static void scrollToElement(WebDriver driver, By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",ElementAction.findElement(driver, locator));
    }

    public static void scrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

}
