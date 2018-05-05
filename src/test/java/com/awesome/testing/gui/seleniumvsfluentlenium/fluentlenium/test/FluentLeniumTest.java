package com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.test;

import com.awesome.testing.utils.Properties;
import org.fluentlenium.adapter.junit.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class FluentLeniumTest extends FluentTest {

    private Properties properties = new Properties();

    public WebDriver newWebDriver() {
        if (IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("my_chrome_path"));
        }
        return new ChromeDriver();
    }

}