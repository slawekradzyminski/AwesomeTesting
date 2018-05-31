package com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.test;

import com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages.MainPage;
import com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages.PostPage;
import com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages.SearchResultsPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

public class SearchTest extends FluentLeniumTest {

    @Page
    private MainPage mainPage;

    @Page
    private SearchResultsPage searchResultsPage;

    @Page
    private PostPage postPage;

    @Test
    public void shouldSuccessfullySearchForPosts() {
        mainPage.go();
        mainPage.isAt();
        mainPage.searchFor("public speaking");

        searchResultsPage.isAt();
        searchResultsPage.assertThatPostsAreDisplayed();
        searchResultsPage.clickOnFirstPost();

        postPage.isAt();
        postPage.checkCommentsSectionPresence();
    }
}