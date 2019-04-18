package com.awesome.testing.gui.headless;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxTest extends AbstractHeadlessTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", myProperties.getProperty("my_gecko_path"));
        driver = new FirefoxDriver(getFirefoxOptions());
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return options;
    }

    @Test
    public void firefoxTest() {
        shouldSuccessfullyFindPostAndDisplayCommentsSection(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
