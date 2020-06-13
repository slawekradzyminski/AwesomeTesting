package com.awesome.testing.gui.jamesclear;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;

@PageUrl("https://jamesclear.com/great-speeches")
public class SpeechListPage extends FluentPage {

    private final String speechLinkSelector = ".entry-content ul li a";

    public SpeechPage openSpeech(int number) {
        int index = number - 1;
        $(speechLinkSelector).get(index).click();
        return newInstance(SpeechPage.class);
    }

    public int getNumberOfPosts() {
        return $(speechLinkSelector).count();
    }
}
