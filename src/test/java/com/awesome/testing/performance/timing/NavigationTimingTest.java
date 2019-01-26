package com.awesome.testing.performance.timing;

import com.awesome.testing.gui.browsermobproxy.pages.AwesomeTestingPage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void testBMICalculator_Perf() throws Exception {
        goTo(awesomeTestingPage);
        long loadEventEnd = executeScript("return window.performance.timing.loadEventEnd;")
                .getLongResult();

        long navigationStart = executeScript("return window.performance.timing.navigationStart;")
                .getLongResult();

        System.out.println("Page Load Time is " + (loadEventEnd - navigationStart) / 1000 + " seconds.");
    }

}
