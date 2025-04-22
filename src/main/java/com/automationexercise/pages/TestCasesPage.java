package com.automationexercise.pages;

import com.automationexercise.utils.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    private WebDriver driver;
    private By pageHeaderText = By.xpath("//b[text()='Test Cases']");


    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageHeaderText() {
        return ElementAction.getText(driver, pageHeaderText);
    }


}
