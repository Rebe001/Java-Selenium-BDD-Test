package com.example.app.webdriver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver setDriver(String webBrowser) {
        switch (webBrowser.toUpperCase()) {
            case "FIREFOX":
                // code commented here won't work
                // it is just for demo purpose that firefox driver can be initialised in this way
                // driver = new FirefoxBrowser();
                break;
            case "IE":
                //same applied here for IE driver
                //driver = new InternetExplorerDriver();
                break;
            default:
                ChromeBrowser chrome = new ChromeBrowser();
                chrome.setDriverPath();
                driver = chrome.setDriverConfiguration();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

}
