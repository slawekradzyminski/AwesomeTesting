package browsercapabilities.chrome.test;

import browsercapabilities.chrome.utils.ChromeManipulator;
import org.testng.annotations.Test;

/**
 * See more at http://awesome-testing.blogspot.com/2016/02/selenium-browser-capabilities-explained.html
 */
public class FacebookTest extends ChromeManipulator {

    @Test
    public void checkWholeScreenFacebook() {
        goTo("http://www.facebook.com");

    }
}
