package com.awesome.testing.gui.headlessfirefox.test;

import com.awesome.testing.gui.browsermobproxy.pages.AwesomeTestingPage;
import com.awesome.testing.gui.headlessfirefox.utils.FirefoxManipulator;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

/**
 * See more at http://www.awesome-testing.com/2017/09/headless-testing-with-firefox.html
 */
public class HeadlessFirefoxDemoTest extends FirefoxManipulator {

    private static final int EXPECTED_NUMBER_OF_POSTS = 3;

    @Page
    private AwesomeTestingPage awesomeTestingPage;

    @Test
    public void correctNumberOfPostsShouldBeDisplayed() {
        goTo(awesomeTestingPage)
                .assertThatCorrectNumberOfPostsIsDisplayed(EXPECTED_NUMBER_OF_POSTS);
    }

}
