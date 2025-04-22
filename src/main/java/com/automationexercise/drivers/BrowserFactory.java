package com.automationexercise.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.PageLoadStrategy.NORMAL;

public class BrowserFactory {

    private BrowserFactory(){
    }

    public static WebDriver setBrowser(String browserName) {
        WebDriver driver = null;
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(getEdgeOptions());
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(NORMAL);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        return options;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(NORMAL);
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("dom.webnotifications.serviceworker.enabled", false);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        //disable security
        options.addArguments("--disable-preferences");
        return options;
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(NORMAL);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        return options;
    }


}
