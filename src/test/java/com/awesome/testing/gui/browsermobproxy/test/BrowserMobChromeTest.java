package com.awesome.testing.gui.browsermobproxy.test;

import com.awesome.testing.gui.browsermobproxy.pages.AwesomeTestingPage;
import com.awesome.testing.gui.browsermobproxy.pages.GoogleHomePage;
import com.awesome.testing.gui.browsermobproxy.pages.GoogleSearchResultPage;
import com.awesome.testing.gui.browsermobproxy.utils.BrowserMobChrome;
import net.lightbody.bmp.core.har.Har;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * See more at http://awesome-testing.com/2016/10/browsermob-proxy-selenium-network.html
 */
public class BrowserMobChromeTest extends BrowserMobChrome {

    @Page
    private AwesomeTestingPage awesomeTestingPage;

    @Page
    private GoogleHomePage googleHomePage;

    @Test
    public void awesomeTestingOnly() throws IOException {
        server.newHar("Awesome Testing Only Test");

        awesomeTestingPage.go();
        awesomeTestingPage.isAt();

        Har har = server.getHar();
        har.writeTo(new File("at.har"));
    }

    @Test
    public void googleAwesomeTesting() throws IOException {
        server.newHar("Google Awesome Testing Test");
        googleHomePage.go();
        googleHomePage.isAt();

        GoogleSearchResultPage googleSearchResultPage = googleHomePage.search("Awesome Testing blog");
        googleSearchResultPage.isAt();

        AwesomeTestingPage awesomeTestingPage = googleSearchResultPage.clickLink("Awesome Testing");
        awesomeTestingPage.isAt();

        Har har = server.getHar();
        har.writeTo(new File("googleat.har"));
    }

}
