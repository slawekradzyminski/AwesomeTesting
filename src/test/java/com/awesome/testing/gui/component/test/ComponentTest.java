package com.awesome.testing.gui.component.test;

import com.awesome.testing.gui.component.pages.MainPage;
import com.awesome.testing.gui.component.pages.QuickStartPage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ComponentTest extends FluentTest {

    private static final Dimension FULL_HD = new Dimension(1920, 1080);

    @Page
    private QuickStartPage quickStartPage;

    @Page
    private MainPage mainPage;

    @Before
    public void setUp() {
        getDriver().manage().window().setSize(FULL_HD);
    }

    @Override
    public WebDriver newWebDriver() {
        return new FirefoxDriver();
    }

    @Test
    public void quickStartLink() {
        mainPage.go();
        mainPage.assertThatPageIsLoaded();

        mainPage.getHeader()
                .clickQuickstartLink()
                .assertThatPageIsLoaded();
    }

    @Test
    public void homeLink() {
        quickStartPage.go();
        quickStartPage.assertThatPageIsLoaded();

        quickStartPage.getHeader()
                .clickHomeLink()
                .assertThatPageIsLoaded();
    }

    @Test
    public void shouldShowSlawomir() {
        mainPage.go();
        mainPage.assertThatPageIsLoaded();

        mainPage.getHeader()
                .clickAboutLink()
                .assertThatPageIsLoaded()
                .verifySlawomirPresence();
    }

}
