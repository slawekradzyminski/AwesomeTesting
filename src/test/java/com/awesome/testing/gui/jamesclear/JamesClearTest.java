package com.awesome.testing.gui.jamesclear;

import com.awesome.testing.gui.browsercapabilities.chrome.utils.ChromeManipulator;
import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.epub.EpubWriter;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class JamesClearTest extends ChromeManipulator {

    private Book book;

    @Page
    private SpeechListPage speechListPage;

    @Before
    public void setUp() {
        book = new Book();
        Metadata metadata = book.getMetadata();
        metadata.addTitle("Famous Speeches");
        metadata.addAuthor(new Author("James", "Clear"));
    }

    @Test
    public void scrapSpeeches() throws IOException {
        goTo(speechListPage);
        int numberOfPosts = speechListPage.getNumberOfPosts();

        for (int i = 1; i <= numberOfPosts; i++) {
            book = speechListPage.openSpeech(i).addToBook(book);
            getDriver().navigate().back();
        }
        createEpub();
    }

    private void createEpub() throws IOException {
        EpubWriter epubWriter = new EpubWriter();
        epubWriter.write(book, new FileOutputStream("James_Clear_speeches.epub"));
    }
}
