package com.awesome.testing.gui.proxy.test;

import com.awesome.testing.gui.proxy.utils.ChromeProxyConfig;
import org.junit.Before;
import org.junit.Test;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

/**
 * See more at http://www.awesome-testing.com
 */
public class ChromeProxyTest extends ChromeProxyConfig {

    private static final String URL = "https://www.google.com/";

    private static final String MY_CHROMEDRIVER_PATH = "C:\\drivers\\chromedriver.exe";

    @Before
    public void setUp() {
        if (IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", MY_CHROMEDRIVER_PATH);
        }
    }

    @Test
    public void theSimplestPossibleTest() {
        goTo(URL);
    }
}

