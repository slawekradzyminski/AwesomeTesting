package com.awesome.testing.gui.browsercapabilities.firefox.utils;

import org.apache.commons.lang3.SystemUtils;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class FirefoxManipulator extends FluentTest {

    private static final String HOMEPAGE_KEY = "browser.startup.homepage";
    private static final String HOMEPAGE_VALUE = "www.google.pl";

    private static final String MY_GECKO_PATH = "C:\\drivers\\geckodriver.exe";

    @Before
    public void setUp() {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.gecko.driver", MY_GECKO_PATH);
        }
    }

    @Override
    public WebDriver newWebDriver() {
        return new FirefoxDriver(getFirefoxCapabilities());
    }

    private DesiredCapabilities getFirefoxCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setAcceptInsecureCerts(true);
        capabilities.setCapability(HOMEPAGE_KEY, HOMEPAGE_VALUE);
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());
        return capabilities;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setLogLevel(Level.WARNING);
        return options;
    }
}
