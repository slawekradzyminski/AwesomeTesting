package com.awesome.testing.gui.downloadingfiles.test;

import com.awesome.testing.gui.downloadingfiles.utils.Request;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://awesome-testing.com/2016/06/how-to-download-files-using-selenium-2.html
 */
public class DownloadNoSeleniumTest {

    @Test
    public void downloadNoSelenium() throws URISyntaxException, IOException {
        Request request = new Request();
        String linkToCheck = "http://www.developsense.com/courses/RapidSoftwareTesting.pdf";
        request.setURIToCheck(linkToCheck);
        assertThat(request.getHTTPStatusCodeFromResponse()).isEqualTo(SC_OK);
    }
}
