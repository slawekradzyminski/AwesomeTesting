package com.awesome.testing.gui.xss.test;

import com.awesome.testing.gui.xss.pages.XssGameLevelOnePage;
import com.awesome.testing.gui.xss.utils.XssDisabledChromeConfig;
import org.apache.commons.lang3.SystemUtils;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://www.awesome-testing.com/2017/11/automate-your-xss-tests-with-selenium.html
 */
public class XssGameTest extends XssDisabledChromeConfig {

    private static final String MY_CHROME_PATH = "C:\\drivers\\chromedriver.exe";
    private static final String XSS_CONTENT = "<script>alert(\"1\");</script>";

    @BeforeTest
    public void setUp() {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", MY_CHROME_PATH);
        }
    }

    @Page
    private XssGameLevelOnePage xssGameLevelOnePage;

    @Test
    public void xssShouldNotWork() {
        goTo(xssGameLevelOnePage).isAt();

        xssGameLevelOnePage.searchFor(XSS_CONTENT);

        assertThat(xssGameLevelOnePage.isAlertDisplayed()).isFalse();
    }
}
