package com.awesome.testing.performance.timing;

import com.awesome.testing.gui.browsermobproxy.pages.AwesomeTestingPage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.awesome.testing.performance.timing.PerformanceEvent.LOAD_EVENT_END;
import static com.awesome.testing.performance.timing.PerformanceEvent.NAVIGATION_START;

public class NavigationTimingTest extends FluentTest {

    private static final String MY_CHROMEDRIVER_PATH =
            "C:\\drivers\\chromedriver.exe";
    @Page
    private AwesomeTestingPage awesomeTestingPage;

    @Override
    public WebDriver newWebDriver() {
        System.setProperty("webdriver.chrome.driver", MY_CHROMEDRIVER_PATH);
        return new ChromeDriver();
    }

    @Test
    public void testBMICalculator_Perf() {
        goTo(awesomeTestingPage);
        long loadEventEnd = getEventValue(LOAD_EVENT_END);
        long navigationStart = getEventValue(NAVIGATION_START);

        System.out.println(
                "Page Load Time is " + (loadEventEnd - navigationStart) / 1000 + " seconds.");
    }

    private long getEventValue(PerformanceEvent event) {
        String script = String.format("return window.performance.timing.%s;", event);
        return executeScript(script).getLongResult();
    }

}
