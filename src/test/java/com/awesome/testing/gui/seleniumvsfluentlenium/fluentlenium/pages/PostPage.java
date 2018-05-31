package com.awesome.testing.gui.seleniumvsfluentlenium.fluentlenium.pages;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import java.util.concurrent.TimeUnit;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends FluentPage {

    @FindBy(id = "comment-editor")
    private FluentWebElement commentsSection;

    @FindBy(name = "commentBody")
    private FluentWebElement commentBody;

    public void isAt() {
        assertThat(commentsSection).isDisplayed();
    }

    public void checkCommentsSectionPresence() {
        switchTo(commentsSection);
        await().atMost(5, TimeUnit.SECONDS).until(commentBody).displayed();
    }
}