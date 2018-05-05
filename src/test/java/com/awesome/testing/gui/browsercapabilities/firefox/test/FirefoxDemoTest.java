package com.awesome.testing.gui.browsercapabilities.firefox.test;

import com.awesome.testing.gui.browsercapabilities.firefox.utils.FirefoxManipulator;
import org.junit.Test;

/**
 * See more at http://www.awesome-testing.com/2017/09/firefox-selenium-browser-capabilities.html
 */
public class FirefoxDemoTest extends FirefoxManipulator {

    @Test
    public void caCertNoWarning() {
        goTo("https://cacert.org");
    }

}
