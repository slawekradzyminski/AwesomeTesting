package com.awesome.testing.gui.jserrors;

import com.awesome.testing.gui.browsermobproxy.pages.AwesomeTestingPage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;

import static junit.framework.TestCase.fail;

public class JavascriptErrorsInChrome extends FluentTest {

    @Page
    private AwesomeTestingPage awesomeTestingPage;

    private static final String MY_CHROMEDRIVER_PATH =
            "C:\\drivers\\chromedriver.exe";

    @Override
    public WebDriver newWebDriver() {
        System.setProperty("webdriver.chrome.driver", MY_CHROMEDRIVER_PATH);
        return new ChromeDriver();
    }

    @Test
    public void pageHopefullyWithoutErrors() {
        goTo(awesomeTestingPage);
    }

    @Test
    public void pageWithErrors() throws URISyntaxException {
        goToFileInResources("pageWithError.html");
    }

    private void goToFileInResources(String fileName) throws URISyntaxException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URI path  = classLoader.getResource(fileName).toURI();
        goTo(path.toString());
    }

    @After
    public void verifyConsoleErrors() {
        Logs logs = getDriver().manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
        List<LogEntry> errorLogs = logEntries.filter(Level.SEVERE);

        if (errorLogs.size() != 0) {
            for (LogEntry logEntry: logEntries) {
                System.out.println("Found error in logs: " + logEntry.getMessage() );
            }
            fail(errorLogs.size() + " Console error found");
        }
    }

}