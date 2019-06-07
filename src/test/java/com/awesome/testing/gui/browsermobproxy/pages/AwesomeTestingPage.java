package com.awesome.testing.gui.browsermobproxy.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@PageUrl("http://www.awesome-testing.com")
public class AwesomeTestingPage extends FluentPage {

    @FindBy(css = "[alt='Software testing Blog – Awesome Testing']")
    private FluentWebElement logo;

    @FindBy(css = "h1.post-title")
    private FluentList<FluentWebElement> postTitle;

    @Override
    public void isAt() {
        await().atMost(5, TimeUnit.SECONDS).until(logo).displayed();
    }

    public void assertThatCorrectNumberOfPostsIsDisplayed(int numberOfPosts) {
        await().until(postTitle).displayed();
        assertThat(postTitle.size()).isEqualTo(numberOfPosts);
    }
}
