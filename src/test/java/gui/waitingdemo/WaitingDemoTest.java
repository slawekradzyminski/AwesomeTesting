package gui.waitingdemo;

import org.fluentlenium.adapter.FluentTestNg;
import org.fluentlenium.core.Fluent;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://awesome-testing.blogspot.com/2016/04/introducing-fluentlenium-2-selenium.html
 */
public class WaitingDemoTest extends FluentTestNg {

    private static final String URL = "https://resttesttest.com/";
    private static final String SUCCESS_TEXT = "HTTP 200 OK";

    private static final String AJAX_BUTTON_CSS = "#submitajax";
    private static final String ALERT_RESULT_CSS = ".alert-success";

    @Test
    public void ajaxCallTest() {
        goTo(URL);
        await().until(AJAX_BUTTON_CSS).isClickable();
        findFirst(AJAX_BUTTON_CSS).click();
        await().atMost(5, TimeUnit.SECONDS).untilPredicate(ajaxCallCompleted::test);
        assertThat(findFirst(ALERT_RESULT_CSS).getText()).isEqualTo(SUCCESS_TEXT);
    }

    public Predicate<Fluent> ajaxCallCompleted = fluent -> {
        final JavascriptExecutor driver = (JavascriptExecutor) getDriver();
        return (Boolean) driver
                .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
    };

}

