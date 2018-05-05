package com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.test;

import com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages.MainPage;
import com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages.SearchResultsPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

public class SearchTest extends FluentLeniumTest {

    @Page
    private MainPage mainPage;

    @Page
    private SearchResultsPage searchResultsPage;

    @Test
    public void shouldSuccessfullySearchForPosts() {
        mainPage.go();
        mainPage.isAt();
        mainPage.searchFor("FluentLenium");

        searchResultsPage.isAt();
        searchResultsPage.assertThatPostsAreDisplayed();
    }
}