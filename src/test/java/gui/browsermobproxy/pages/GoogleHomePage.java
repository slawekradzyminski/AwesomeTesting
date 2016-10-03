package gui.browsermobproxy.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class GoogleHomePage extends FluentPage {

    private static final String SEARCH_BOX_SELECTOR = "[role='combobox']";

    @Override
    public String getUrl() {
        return "https://www.google.com";
    }

    @Override
    public void isAt() {
        await().atMost(5, TimeUnit.SECONDS).until(SEARCH_BOX_SELECTOR).isDisplayed();
    }

    public GoogleSearchResultPage search(String searchPhrase) {
    findFirst(SEARCH_BOX_SELECTOR).fill().with(searchPhrase + Keys.ENTER);
        return createPage(GoogleSearchResultPage.class);
    }

}
