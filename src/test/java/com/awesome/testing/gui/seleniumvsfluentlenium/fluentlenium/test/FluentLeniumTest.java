package com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.test;

import com.awesome.testing.utils.MyProperties;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class FluentLeniumTest extends FluentTest {

    protected static WebDriver driver;
    private static MyProperties myProperties = new MyProperties();

    @BeforeClass
    public static void setUp() {
        if (IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", myProperties.getProperty("my_chrome_path"));
        }
    }

    @Override
    public String getWebDriver() {
        return myProperties.getProperty("driver");
    }
}
