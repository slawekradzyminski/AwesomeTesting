package com.awesome.testing.gui.component.pages;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import org.assertj.core.api.Assertions;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends FluentPage {

    @FindBy(className = "username")
    private FluentList<FluentWebElement> contributors;

    public AboutPage assertThatPageIsLoaded() {
        assertThat(contributors).hasSize().greaterThan(0);
        return this;
    }

    public void verifySlawomirPresence() {
        Assertions.assertThat(contributors.texts()).contains("Sławomir Radzymiński");
    }

}
