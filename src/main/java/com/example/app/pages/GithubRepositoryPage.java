package com.example.app.pages;

import com.example.app.common.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubRepositoryPage extends Helper {

    public GithubRepositoryPage(WebDriver driver) { super(driver); }

    @FindBy(css = "article > h1")
    private WebElement header;

    public void verifyHeader (String repoName) {
        verifyHeader(header, repoName);
    }
}
