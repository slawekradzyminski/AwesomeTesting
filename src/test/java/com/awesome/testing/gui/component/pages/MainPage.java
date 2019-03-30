package com.awesome.testing.gui.component.pages;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import com.awesome.testing.gui.component.components.Footer;
import com.awesome.testing.gui.component.components.Header;
import com.awesome.testing.gui.component.components.Sidebar;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("https://fluentlenium.com")
public class MainPage extends FluentPage {

    @FindBy(css = "div.sidebar")
    private Sidebar sidebar;

    @FindBy(css = "div.footer")
    private Footer footer;

    @FindBy(css = "nav")
    private Header header;

    @FindBy(className = "whats-fluentlenium")
    private FluentWebElement mainContent;

    public void assertThatPageIsLoaded() {
        assertThat(mainContent).isDisplayed();
    }

    public Header getHeader() {
        return header;
    }

}
