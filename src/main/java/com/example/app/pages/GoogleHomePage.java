package com.example.app.pages;

import com.example.app.common.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleHomePage extends Helper {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public GoogleHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement queryElement;

    @FindBy(xpath = "//div[text()='Acepto']")
    private WebElement introAgreeButton;

    public void closeWindowHandle(){
        try {
            this.driver.switchTo().window(this.driver.getWindowHandle());
            new WebDriverWait(this.driver, 3).until(ExpectedConditions.elementToBeClickable(introAgreeButton)).click();
        } catch (TimeoutException ex) {
            logger.info("No Google agreement Iframe detected with exception:" + ex);
        }
    }

    public void setSearchQuery(String query) {
        closeWindowHandle();
        sendSearchQuery(queryElement,query);
    }

}
