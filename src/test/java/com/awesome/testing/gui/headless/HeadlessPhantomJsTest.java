package com.awesome.testing.gui.headless;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class HeadlessPhantomJsTest extends AbstractHeadlessTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("phantomjs.binary.path", myProperties.getProperty("my_phantom_path"));
        driver = new PhantomJSDriver();
    }

    @Test
    public void phantomJsTest() {
        shouldSuccessfullyFindPostAndDisplayCommentsSection(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
