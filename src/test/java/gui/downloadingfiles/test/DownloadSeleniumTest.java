package gui.downloadingfiles.test;

import gui.downloadingfiles.utils.Request;
import org.fluentlenium.adapter.FluentTestNg;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://awesome-testing.blogspot.com/2016/06/how-to-download-files-using-selenium-2.html
 */
public class DownloadSeleniumTest extends FluentTestNg {

    private static final String EXPECTED_MD5 = "c3fb273e2843808968d68120121f2c74";
    private static final String FILE_TO_DL_SELECTOR = "ul li a";
    private static final String URL = "http://www.developsense.com";

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
        await().until(FILE_TO_DL_SELECTOR).isEnabled();
        return findFirst(FILE_TO_DL_SELECTOR).getAttribute("href");
    }

    private String calculateMd5(File downloadedFile) throws IOException {
        FileInputStream fis = new FileInputStream(downloadedFile);
        String md5 = md5Hex(fis);
        fis.close();
        return md5;
    }

}
