package com.awesome.testing.gui.component.pages;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import com.awesome.testing.gui.component.components.Header;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("https://fluentlenium.com/quickstart/")
public class QuickStartPage extends FluentPage {

    @FindBy(id = "table-of-contents")
    private FluentWebElement tableOfContents;

    @FindBy(css = "nav")
    private Header header;

    public void assertThatPageIsLoaded() {
        assertThat(tableOfContents).isDisplayed();
    }

    public Header getHeader() {
        return header;
    }

}
