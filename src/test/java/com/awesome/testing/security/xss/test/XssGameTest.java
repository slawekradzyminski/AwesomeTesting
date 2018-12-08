package com.awesome.testing.security.xss.test;

import com.awesome.testing.utils.MyProperties;
import com.awesome.testing.security.xss.pages.XssGameLevelOnePage;
import com.awesome.testing.security.xss.utils.XssDisabledChromeConfig;
import org.apache.commons.lang3.SystemUtils;
import org.fluentlenium.core.annotation.Page;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://www.awesome-testing.com/2017/11/automate-your-xss-tests-with-selenium.html
 */
public class XssGameTest extends XssDisabledChromeConfig {

    private static final String XSS_CONTENT = "<script>alert(\"1\");</script>";

    private static MyProperties myProperties = new MyProperties();

    @Page
    private XssGameLevelOnePage xssGameLevelOnePage;

    @BeforeClass
    public static void setUp() {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", myProperties.getProperty("my_chrome_path"));
        }
    }

    @Test
    public void xssShouldNotWork() {
        goTo(xssGameLevelOnePage).isAt();

        xssGameLevelOnePage.searchFor(XSS_CONTENT);

        assertThat(xssGameLevelOnePage.isAlertDisplayed()).isFalse();
    }
}
