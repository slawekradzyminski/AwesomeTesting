package com.awesome.testing.gui.waitingdemo;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.FluentControl;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://awesome-testing.com/2016/04/introducing-fluentlenium-2-selenium.html
 */
public class WaitingDemoTest extends FluentTest {

    private static final String URL = "https://resttesttest.com/";
    private static final String SUCCESS_TEXT = "HTTP 200 OK";

    private static final String AJAX_BUTTON_CSS = "#submitajax";
    private static final String ALERT_RESULT_CSS = ".alert-success";
    private Predicate<FluentControl> ajaxCallCompleted = fluent -> {
        final JavascriptExecutor driver = (JavascriptExecutor) getDriver();
        return (Boolean) driver
                .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
    };

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver();
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void ajaxCallTest() {
        goTo(URL);
        await().until(el(AJAX_BUTTON_CSS)).clickable();
        el(AJAX_BUTTON_CSS).click();
        await().atMost(5, TimeUnit.SECONDS).untilPredicate(ajaxCallCompleted);
        assertThat(el(ALERT_RESULT_CSS).text()).isEqualTo(SUCCESS_TEXT);
    }

}

