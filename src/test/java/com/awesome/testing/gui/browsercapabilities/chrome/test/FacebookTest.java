package com.awesome.testing.gui.browsercapabilities.chrome.test;

import com.awesome.testing.gui.browsercapabilities.chrome.utils.ChromeManipulator;
import org.junit.Test;

/**
 * See more at http://awesome-testing.com/2016/02/selenium-browser-capabilities-explained.html
 */
public class FacebookTest extends ChromeManipulator {

    @Test
    public void checkWholeScreenFacebook() {
        goTo("http://www.facebook.com");

    }
}
