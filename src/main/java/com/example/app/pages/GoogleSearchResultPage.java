package com.example.app.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleSearchResultPage {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private WebDriver driver;

    public GoogleSearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".g a")
    private WebElement firstResult;

    public void clickOnFirstResult() {
        try {
            new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(firstResult));
            firstResult.click();
        } catch (TimeoutException ex) {
            logger.error("first result cannot be clickable");
        }
    }

}
