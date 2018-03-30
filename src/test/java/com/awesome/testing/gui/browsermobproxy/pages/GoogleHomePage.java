package com.awesome.testing.gui.browsermobproxy.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class GoogleHomePage extends FluentPage {

    private static final String SEARCH_BOX_SELECTOR = "[role='combobox']";

    @Override
    public String getUrl() {
        return "https://www.google.com";
    }

    @Override
    public void isAt() {
        await().atMost(5, TimeUnit.SECONDS).until(el(SEARCH_BOX_SELECTOR)).displayed();
    }

    public GoogleSearchResultPage search(String searchPhrase) {
        el(SEARCH_BOX_SELECTOR).fill().with(searchPhrase + Keys.ENTER);
        return newInstance(GoogleSearchResultPage.class);
    }

}
