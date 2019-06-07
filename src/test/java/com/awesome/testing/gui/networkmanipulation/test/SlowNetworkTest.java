package com.awesome.testing.gui.networkmanipulation.test;

import com.awesome.testing.gui.browsermobproxy.pages.AwesomeTestingPage;
import com.awesome.testing.gui.networkmanipulation.ThrottledChrome;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

public class SlowNetworkTest extends ThrottledChrome {

    @Page
    private AwesomeTestingPage awesomeTestingPage;

    @Test
    public void shouldLoadBlogOnSlowNetwork() {
        goTo(awesomeTestingPage).isAt();
    }

}
