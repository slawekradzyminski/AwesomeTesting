package com.awesome.testing.gui.headless;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessHtmlUnitTest extends AbstractHeadlessTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
    }

    @Test
    public void htmlUnitTest() {
        shouldSuccessfullyFindPostAndDisplayCommentsSection(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
