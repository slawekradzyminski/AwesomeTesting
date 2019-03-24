package com.awesome.testing.gui.disabledjs.firefox.utils;

import com.awesome.testing.utils.MyProperties;
import org.apache.commons.lang3.SystemUtils;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxManipulator extends FluentTest {

    private static final String JAVASCRIPT_ENABLED = "javascript.enabled";

    @BeforeClass
    public static void setUp() {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.gecko.driver",
                    new MyProperties().getProperty("my_gecko_path"));
        }
    }

    @Override
    public WebDriver newWebDriver() {
        return new FirefoxDriver(getFirefoxOptions());
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference(JAVASCRIPT_ENABLED, false);
        return options;
    }
}
