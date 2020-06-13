package com.awesome.testing.gui.jamesclear;

import nl.siegmann.epublib.domain.Book;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class SpeechPage extends FluentPage {

    @FindBy(className = "entry-title")
    private FluentWebElement title;

    @FindBy(className = "entry-content")
    private FluentWebElement content;

    public Book addToBook(Book book) throws IOException {
        await().until(content).present();
        String speechTitle = title.textContent();
        String speechText = content.html();

        ChapterWriter chapterWriter = new ChapterWriter(speechTitle, speechText, book);
        return chapterWriter.addToBook();
    }

}
