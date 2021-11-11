package com.example.app.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeBrowser implements Driver {

    private ChromeOptions setChromeOption() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        return new ChromeOptions();
    }

    @Override
    public RemoteWebDriver setDriverConfiguration() {
        return new ChromeDriver(setChromeOption());
    }

    @Override
    public void setDriverPath() {
        String sBasePath = System.getProperty("user.dir") + "/src/main/resources/driver/";
        String chromePath = "chrome/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", sBasePath + chromePath);
    }
}
