package com.example.app.pages;

import com.example.app.common.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubSearchResultPage extends Helper {

    public GithubSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    private WebElement result;

    public void clickSearchResult(String item){ clickOnElementByPartialLink(result, item); }
}
