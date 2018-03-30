package com.awesome.testing.gui.selectors.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@PageUrl("http://www.awesome-testing.com/")
public class HomePage extends FluentPage {

    @FindBy(css = "#Header1_headerimg")
    private FluentWebElement header;

    @FindBy(css = "h1.post-title")
    private FluentList<FluentWebElement> pageTitles;

    public void assertThatHeaderIsDisplayed() {
        assertThat(header).isDisplayed();
    }

    public void assertThatNumberOfTitlesEquals(int numberOfTitles) {
        assertThat(pageTitles).hasSize(numberOfTitles);
    }
}
