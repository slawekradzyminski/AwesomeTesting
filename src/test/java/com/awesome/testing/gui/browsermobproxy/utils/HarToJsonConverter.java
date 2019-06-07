package com.awesome.testing.gui.browsermobproxy.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.HarEntry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class HarToJsonConverter {

    public static void main(String[] args) throws HarReaderException, IOException {
        String pathToFile = "at.har";

        HarReader harReader = new HarReader();
        List<HarEntry> harEntryList = harReader.readFromFile(new File(pathToFile)).getLog().getEntries();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("filename.txt"), StandardCharsets.UTF_8))) {
            writer.write(gson.toJson(harEntryList));
        }
    }

}
