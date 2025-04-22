package com.automationexercise.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    public static WebDriver createInstance(String browserName) {
        WebDriver driver = BrowserFactory.setBrowser(browserName);
        driverThreadLocal.set(driver);
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driverThreadLocal.set(webDriver);
    }

}
