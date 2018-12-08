package com.awesome.testing.security.owaspzap.selenium;

import org.junit.Test;

/**
 * See more at http://www.awesome-testing.com
 */
public class ChromeProxyTest extends ChromeProxyConfig {

    private static final String URL = "https://www.awesome-testing.com/";

    @Test
    public void theSimplestPossibleProxyTest() {
        goTo(URL);
    }
}
