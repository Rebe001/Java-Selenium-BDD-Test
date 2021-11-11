package com.example.app.webdriver;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface Driver {
    public abstract RemoteWebDriver setDriverConfiguration();

    public abstract void setDriverPath();
}
