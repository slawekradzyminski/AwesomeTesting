package com.awesome.testing.gui.seleniumvsfluentlenium.selenium.test;


import com.awesome.testing.utils.MyProperties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class SeleniumTest {

    protected static WebDriver driver;
    private MyProperties myProperties = new MyProperties();

    @Before
    public void setUp() {
        if (IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", myProperties.getProperty("my_chrome_path"));
        }
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}