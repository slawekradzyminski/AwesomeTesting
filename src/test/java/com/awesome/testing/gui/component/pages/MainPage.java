package com.awesome.testing.gui.component.pages;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import com.awesome.testing.gui.component.components.Header;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("https://fluentlenium.com")
public class MainPage extends FluentPage {

    @FindBy(className = "whats-fluentlenium")
    private FluentWebElement mainContent;

    @FindBy(css = "nav")
    private Header header;

    @Override
    public void isAt() {
        assertThat(mainContent).isDisplayed();
    }

    public Header getHeader() {
        return header;
    }

}
