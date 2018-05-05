package com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

public class SearchResultsPage extends FluentPage {

    @FindBy(className = "status-msg-wrap")
    private FluentWebElement searchOptionPanel;

    @FindBy(css = "h1")
    private FluentList<FluentWebElement> posts;

    @Override
    public void isAt() {
        assertThat(searchOptionPanel).isDisplayed();
    }

    public void assertThatPostsAreDisplayed() {
        assertThat(posts).hasSize().greaterThan(0);
    }
}