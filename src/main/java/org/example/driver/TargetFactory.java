package org.example.driver;

import org.openqa.selenium.WebDriver;

public class TargetFactory {

    public WebDriver createInstance(String browser) {
        return BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
    }
}
