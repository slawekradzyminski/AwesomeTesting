package com.awesome.testing.gui.seleniumvsfluentlenium.selenium.test;

import com.awesome.testing.gui.seleniumvsfluentlenium.selenium.pages.MainPage;
import com.awesome.testing.gui.seleniumvsfluentlenium.selenium.pages.PostPage;
import com.awesome.testing.gui.seleniumvsfluentlenium.selenium.pages.SearchResultsPage;
import org.junit.Test;

public class SearchTest extends SeleniumTest {

    private static final String BLOG = "https://www.awesome-testing.com";

    @Test
    public void shouldSuccessfullyFindPostAndDisplayCommentsSection() {
        driver.get(BLOG);
        MainPage mainPage = new MainPage(driver);
        mainPage.isInitialized();

        SearchResultsPage searchResultsPage =  mainPage.searchFor("public speaking");
        searchResultsPage.isInitialized();
        searchResultsPage.assertThatPostsAreDisplayed();

        PostPage postPage = searchResultsPage.clickOnFirstPost();
        postPage.isInitialized();
        postPage.assertThatCommentSectionIsDisplayed();
    }
}