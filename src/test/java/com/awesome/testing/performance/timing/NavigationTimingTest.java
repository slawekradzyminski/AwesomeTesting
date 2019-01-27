package com.awesome.testing.performance.timing;

import com.awesome.testing.gui.browsermobproxy.pages.AwesomeTestingPage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.awesome.testing.performance.timing.PerformanceEvent.LOAD_EVENT_END;
import static com.awesome.testing.performance.timing.PerformanceEvent.NAVIGATION_START;
import static org.assertj.core.api.Assertions.assertThat;

public class NavigationTimingTest extends FluentTest {

    private static final String MY_EDGEDRIVER_PATH =
            "C:\\drivers\\MicrosoftWebDriver.exe";
    @Page
    private AwesomeTestingPage awesomeTestingPage;

    @Override
    public WebDriver newWebDriver() {
        System.setProperty("webdriver.edge.driver", MY_EDGEDRIVER_PATH);
        return new EdgeDriver();
    }

    @Test
    public void loadTimeTest() {
        goTo(awesomeTestingPage);
        long loadEventEnd = getEventValue(LOAD_EVENT_END);
        long navigationStart = getEventValue(NAVIGATION_START);

        assertThat(getLoadTimeInSeconds(loadEventEnd, navigationStart)).isLessThanOrEqualTo(3);
    }

    private long getLoadTimeInSeconds(long loadEventEnd, long navigationStart) {
        long loadTimeInSeconds = (loadEventEnd - navigationStart) / 1000;
        String logBody = String.format("Page Load Time is %s seconds.", loadTimeInSeconds);
        System.out.println(logBody);
        return loadTimeInSeconds;
    }

    private long getEventValue(PerformanceEvent event) {
        String script = String.format("return window.performance.timing.%s;", event);
        return executeScript(script).getLongResult();
    }

}
