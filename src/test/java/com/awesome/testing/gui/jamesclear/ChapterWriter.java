package com.awesome.testing.gui.jamesclear;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.awesome.testing.gui.jamesclear.Html.HTML_CLOSE;
import static com.awesome.testing.gui.jamesclear.Html.HTML_OPEN;
import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;

public class ChapterWriter {

    private final String title;
    private final String text;
    private final Book book;

    private String filePath;
    private File file;

    public ChapterWriter(String title, String text, Book book) {
        this.title = title;
        this.text = text;
        this.book = book;
    }

    public Book addToBook() throws IOException {
        filePath = String.format("chapter%s.html", randomAlphanumeric(3));
        file = new File(filePath);
        file.createNewFile();
        prepareEpubableHtml();
        book.addSection(title, new Resource(Files.readAllBytes(Paths.get(filePath)), filePath));
        file.delete();
        return book;
    }

    private void prepareEpubableHtml() throws IOException {
        writeToFile(HTML_OPEN);
        writeToFile(text);
        removeVideos();
        writeToFile(HTML_CLOSE);
    }

    private void removeVideos() throws IOException {
        Document doc = Jsoup.parse(file, "UTF-8");
        doc.getElementsByTag("iframe").remove();
        file.delete();
        file.createNewFile();
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        writer.write(doc.html());
        writer.flush();
        writer.close();
    }

    private void writeToFile(String text) throws IOException {
        Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
    }
}
