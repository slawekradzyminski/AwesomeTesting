package com.awesome.testing.gui.headless;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class HeadlessChromeTest extends AbstractHeadlessTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", myProperties.getProperty("my_chrome_path"));
        driver = new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        List<String> chromeSwitches = new ArrayList<>();
        chromeSwitches.add("--headless");
        chromeSwitches.add("--disable-gpu");
        options.addArguments(chromeSwitches);
        return options;
    }

    @Test
    public void chromeTest() {
        shouldSuccessfullyFindPostAndDisplayCommentsSection(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
