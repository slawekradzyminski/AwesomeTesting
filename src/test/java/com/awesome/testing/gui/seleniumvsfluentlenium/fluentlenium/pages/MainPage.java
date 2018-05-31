package com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@PageUrl("https://www.awesome-testing.com")
public class MainPage extends FluentPage {

    @FindBy(css = "input.gsc-input")
    private FluentWebElement searchBar;

    @FindBy(css = "input.gsc-search-button")
    private FluentWebElement searchButton;

    @FindBy(css = "h1")
    private FluentList<FluentWebElement> posts;

    @Override
    public void isAt() {
        assertThat(posts).hasSize().greaterThan(0);
    }

    public SearchResultsPage searchFor(String searchTerm) {
        searchBar.fill().with(searchTerm);
        searchButton.click();
        return newInstance(SearchResultsPage.class);
    }
}