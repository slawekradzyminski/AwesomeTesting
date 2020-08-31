package com.awesome.testing.gui.headlesschrome.test;

import com.awesome.testing.gui.headlesschrome.utils.HeadlessChromeConfig;
import org.fluentlenium.core.FluentControl;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://www.awesome-testing.com/2017/05/headless-testing-with-google-chrome.html
 */
public class HeadlessChromeTest extends HeadlessChromeConfig {

    private static final String URL = "https://resttesttest.com/";
    private static final String SUCCESS_TEXT = "HTTP 200";

    private static final String AJAX_BUTTON_CSS = "#submitajax";
    private static final String ALERT_RESULT_CSS = ".alert-success";

    @SuppressWarnings("Duplicates")
    @Test
    public void ajaxCallTest() {
        goTo(URL);
        await().until(el(AJAX_BUTTON_CSS)).clickable();
        el(AJAX_BUTTON_CSS).click();
        await().atMost(5, TimeUnit.SECONDS).untilPredicate(ajaxCallCompleted);
        assertThat(el(ALERT_RESULT_CSS).text()).contains(SUCCESS_TEXT);
    }

    private Predicate<FluentControl> ajaxCallCompleted = fluent -> {
        final JavascriptExecutor driver = (JavascriptExecutor) getDriver();
        return (Boolean) driver
                .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
    };

}

