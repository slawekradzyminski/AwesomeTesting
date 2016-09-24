package gui.browsercapabilities.firefox.test;

import gui.browsercapabilities.firefox.utils.FirefoxManipulator;
import org.testng.annotations.Test;

/**
 * See more at http://awesome-testing.blogspot.com/2016/02/selenium-browser-capabilities-explained.html
 */
public class FirefoxDemoTest extends FirefoxManipulator {

    @Test
    public void caCertNoWarning() {
        goTo("https://cacert.org");
    }

}
