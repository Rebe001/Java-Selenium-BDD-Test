package com.example.app.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Function;
import static org.assertj.core.api.Assertions.*;

public class Helper {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(Function expectedConditions, WebElement ele){
        try {
            new WebDriverWait(driver, 3).until(expectedConditions);
        } catch (Exception e) {
            logger.error("No web element {} is presented with exception {}", ele, e);
        }
    }

    public void waitForElement(Function expectedConditions, String ele){
        try {
            new WebDriverWait(driver, 3).until(expectedConditions);
        } catch (Exception e) {
            logger.error("No string {} is presented with exception {}", ele, e);
        }
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public void scrollToBottom(WebElement body){
        body.sendKeys(Keys.END);
    }

    public void sendSearchQuery(WebElement ele, String query) {
        waitForElement(ExpectedConditions.visibilityOfAllElements(ele), ele);
        ele.clear();
        ele.sendKeys(query, Keys.ENTER);
    }

    public void clickOnElementByPartialLink(WebElement ele, String item){
        waitForElement(ExpectedConditions.visibilityOfAllElements(ele), ele);
        driver.findElement(By.partialLinkText(item)).click();
    }

    public void verifyCurrentUrl(String url){
        waitForElement(ExpectedConditions.urlToBe(url), url);
        assertThat(driver.getCurrentUrl()).as("Check %s page is landed", url).isEqualTo(url);
    }

    public void verifyHeader(WebElement ele, String header){
        waitForElement(ExpectedConditions.visibilityOfAllElements(ele), ele);
        assertThat(ele.getText()).as("Check %s page is landed", header).isEqualToIgnoringCase(header);
    }
}
