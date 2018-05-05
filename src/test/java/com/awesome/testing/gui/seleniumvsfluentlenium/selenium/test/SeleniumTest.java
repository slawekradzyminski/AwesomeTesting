package com.awesome.testing.gui.seleniumvsfluentlenium.selenium.test;


import com.awesome.testing.utils.Properties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class SeleniumTest {

    protected static WebDriver driver;
    private Properties properties = new Properties();

    @Before
    public void setUp() {
        if (IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("my_chrome_path"));
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}