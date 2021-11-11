package com.example.app.pages;

import com.example.app.common.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubBasePage extends Helper {

    public GithubBasePage(WebDriver driver) { super(driver); }

    @FindBy(name = "q")
    private WebElement queryElement;

    @FindBy(tagName = "nav")
    private WebElement navBar;

    @FindBy(tagName = "footer")
    private WebElement footer;

    @FindBy(tagName = "body")
    WebElement body;

    public void setSearchQuery(String query) {
        sendSearchQuery(queryElement, query);
    }

    public void clickOnNavItem(String item) { clickOnElementByPartialLink(navBar, item); }

    public void clickOnFooterItem(String item) { clickOnElementByPartialLink(footer ,item);}

    public void scrollToBottom(){
        scrollToBottom(body);
    }

}

