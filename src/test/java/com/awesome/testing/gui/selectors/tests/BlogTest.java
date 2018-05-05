package com.awesome.testing.gui.selectors.tests;

import com.awesome.testing.gui.selectors.pages.HomePage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * See more at http://www.awesome-testing.com/2017/05/how-to-find-test-cssselector-using.html
 */
public class BlogTest extends FluentTest {

    private static final int EXPECTED_NUMBER_OF_POSTS = 5;

    @Page
    private HomePage homePage;

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver();
    }

    @Test
    public void shouldDisplayHeader() {
        homePage.go();
        homePage.assertThatHeaderIsDisplayed();
    }

    @Test
    public void shouldBeFivePosts() {
        homePage.go();
        homePage.assertThatNumberOfTitlesEquals(EXPECTED_NUMBER_OF_POSTS);
    }

}
