package gui.browsermobproxy.test;

import gui.browsermobproxy.pages.AwesomeTestingPage;
import gui.browsermobproxy.pages.GoogleHomePage;
import gui.browsermobproxy.pages.GoogleSearchResultPage;
import gui.browsermobproxy.utils.BrowserMobChrome;
import net.lightbody.bmp.core.har.Har;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * See more at http://awesome-testing.blogspot.com/2016/10/browsermob-proxy-selenium-network.html
 */
public class BrowserMobChromeTest extends BrowserMobChrome {

    @Test
    public void awesomeTestingOnly() throws IOException {
        server.newHar("Awesome Testing Only Test");

        AwesomeTestingPage awesomeTestingPage = createPage(AwesomeTestingPage.class);
        awesomeTestingPage.go();
        awesomeTestingPage.isAt();

        Har har = server.getHar();
        har.writeTo(new File("at.har"));
    }

    @Test
    public void googleAwesomeTesting() throws IOException {
        server.newHar("Google Awesome Testing Test");
        GoogleHomePage googleHomePage = createPage(GoogleHomePage.class);
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
