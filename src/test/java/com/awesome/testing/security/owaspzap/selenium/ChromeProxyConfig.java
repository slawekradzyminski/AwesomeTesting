package com.awesome.testing.security.owaspzap.selenium;

import org.fluentlenium.adapter.junit.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class ChromeProxyConfig extends FluentTest {

    private static final String MY_CHROMEDRIVER_PATH = "C:\\drivers\\chromedriver.exe";

    @Override
    public WebDriver newWebDriver() {
        setSystemProperty();
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(getChromeSwitches());
        return options;
    }

    private List<String> getChromeSwitches() {
        List<String> chromeSwitches = new ArrayList<>();
        chromeSwitches.add("--proxy-server=http://localhost:8888");
        chromeSwitches.add("--ignore-certificate-errors");
        return chromeSwitches;
    }

    private void setSystemProperty() {
        if (IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", MY_CHROMEDRIVER_PATH);
        }
    }
}
