package gui.proxy.test;

import gui.proxy.utils.ChromeProxyConfig;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

/**
 * See more at http://www.awesome-testing.com
 */
public class ChromeProxyTest extends ChromeProxyConfig {

    private static final String URL = "https://www.google.com/";

    private static final String MY_CHROMEDRIVER_PATH = "C:\\drivers\\chromedriver.exe";

    @BeforeTest
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

