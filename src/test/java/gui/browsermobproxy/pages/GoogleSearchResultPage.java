package gui.browsermobproxy.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class GoogleSearchResultPage extends FluentPage {

    @Override
    public void isAt() {
        await().atMost(5, TimeUnit.SECONDS).until("#resultStats").isDisplayed();
    }

    public AwesomeTestingPage clickLink(String searchPhrase) {
        findFirst(By.linkText(searchPhrase)).click();
        return createPage(AwesomeTestingPage.class);
    }

}
