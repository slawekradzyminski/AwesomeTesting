package com.awesome.testing.gui.disabledjs.chrome.utils;

import com.awesome.testing.utils.MyProperties;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class ChromeManipulator extends FluentTest {

    private static final String PREFS = "prefs";

    private static final String JAVASCRIPT_SETTINGS = "profile.managed_default_content_settings.javascript";
    private static final short DISABLED = 2;

    @BeforeClass
    public static void setUp() {
        if (IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver",
                    new MyProperties().getProperty("my_chrome_path"));
        }
    }

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(PREFS, getChromePrefs());
        return options;
    }

    private Map<String, Object> getChromePrefs() {
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put(JAVASCRIPT_SETTINGS, DISABLED);
        return chromePrefs;
    }

}
