package gui.headlessfirefox.test;

import gui.browsermobproxy.pages.AwesomeTestingPage;
import gui.headlessfirefox.utils.FirefoxManipulator;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.Test;

/**
 * See more at http://www.awesome-testing.com/2017/09/headless-testing-with-firefox.html
 */
public class HeadlessFirefoxDemoTest extends FirefoxManipulator {

    private static final int EXPECTED_NUMBER_OF_POSTS = 5;

    @Page
    private AwesomeTestingPage awesomeTestingPage;

    @Test
    public void correctNumberOfPostsShouldBeDisplayed() {
        goTo(awesomeTestingPage)
                .assertThatCorrectNumberOfPostsIsDisplayed(EXPECTED_NUMBER_OF_POSTS);
    }

}
