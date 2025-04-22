package com.automationexercise.utils;

import com.automationexercise.drivers.DriverManager;

public class BrowserAction {
    public static void maximizeWindow() {

        DriverManager.getDriver().manage().window().maximize();
    }

    public static void navigateToURL(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void refreshPage() {
        DriverManager.getDriver().navigate().refresh();
    }

    public static String getURL() {
        return DriverManager.getDriver().getCurrentUrl();
    }
}
