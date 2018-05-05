package com.awesome.testing.gui.downloadingfiles.test;

import com.awesome.testing.gui.downloadingfiles.utils.Request;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://awesome-testing.com/2016/06/how-to-download-files-using-selenium-2.html
 */
public class DownloadSeleniumTest extends FluentTest {

    private static final String EXPECTED_MD5 = "c3fb273e2843808968d68120121f2c74";
    private static final String FILE_TO_DL_SELECTOR = "ul li a";
    private static final String URL = "http://www.developsense.com";

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver();
    }

    @Test
    public void statusCode200() throws IOException, URISyntaxException {
        Request request = prepareRequest();
        assertThat(request.getHTTPStatusCodeFromResponse()).isEqualTo(SC_OK);
    }

    @Test
    public void getDownload() throws Exception {
        Request request = prepareRequest();
        File downloadedFile = request.downloadFile();
        assertThat(downloadedFile).isNotNull();
    }

    @Test
    public void getDownloadPlusMd5() throws Exception {
        Request request = prepareRequest();
        File downloadedFile = request.downloadFile();
        assertThat(calculateMd5(downloadedFile)).isEqualTo(EXPECTED_MD5);
    }

    private Request prepareRequest() throws MalformedURLException, URISyntaxException {
        String fileUrl = getUrlFromSite();
        Request request = new Request(getDriver());
        request.setURIToCheck(fileUrl);
        return request;
    }

    private String getUrlFromSite() {
        goTo(URL);
        await().until(el(FILE_TO_DL_SELECTOR)).enabled();
        return el(FILE_TO_DL_SELECTOR).attribute("href");
    }

    private String calculateMd5(File downloadedFile) throws IOException {
        FileInputStream fis = new FileInputStream(downloadedFile);
        String md5 = md5Hex(fis);
        fis.close();
        return md5;
    }

}
