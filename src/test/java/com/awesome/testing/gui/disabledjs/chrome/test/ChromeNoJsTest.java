package com.awesome.testing.gui.disabledjs.chrome.test;

import com.awesome.testing.gui.disabledjs.chrome.utils.ChromeManipulator;
import com.awesome.testing.gui.disabledjs.page.FacebookMainPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ChromeNoJsTest extends ChromeManipulator {

    private static final String FACEBOOK_NO_JS_URL = "https://www.facebook.com/?_fb_noscript=1";

    @Page
    private FacebookMainPage facebookMainPage;

    @Test
    public void checkJsDisabled() {
        facebookMainPage.go();
        waitForFacebookNoJsUrlAppender();
    }

    private void waitForFacebookNoJsUrlAppender() {
        await().atMost(2, TimeUnit.SECONDS).until(
                () -> getDriver().getCurrentUrl().equals(FACEBOOK_NO_JS_URL));
    }
}
