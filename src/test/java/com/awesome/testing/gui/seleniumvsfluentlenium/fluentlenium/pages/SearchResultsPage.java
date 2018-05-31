package com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends FluentPage {

    @FindBy(className = "status-msg-wrap")
    private FluentWebElement searchOptionPanel;

    @FindBy(css = "h1 a")
    private FluentList<FluentWebElement> posts;

    @Override
    public void isAt() {
        assertThat(searchOptionPanel).isDisplayed();
    }

    public void assertThatPostsAreDisplayed() {
        assertThat(posts).hasSize().greaterThan(0);
    }

    public PostPage clickOnFirstPost() {
        posts.first().click();
        return newInstance(PostPage.class);
    }
}