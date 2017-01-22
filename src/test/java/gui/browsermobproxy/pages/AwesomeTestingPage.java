package gui.browsermobproxy.pages;

import org.fluentlenium.core.FluentPage;

import java.util.concurrent.TimeUnit;

public class AwesomeTestingPage extends FluentPage {

    private static final String LOGO_SELECTOR = "[alt='Awesome Testing']";

    @Override
    public String getUrl() {
        return "http://awesome-testing.blogspot.com/";
    }

    @Override
    public void isAt() {
        await().atMost(5, TimeUnit.SECONDS).until(el(LOGO_SELECTOR)).displayed();
    }

}
