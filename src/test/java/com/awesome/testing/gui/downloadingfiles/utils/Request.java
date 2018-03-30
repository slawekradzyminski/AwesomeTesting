package com.awesome.testing.gui.downloadingfiles.utils;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

public class Request {

    private URI linkToCheck;
    private WebDriver driver;

    public Request(WebDriver driver) {
        this.driver = driver;
    }

    public Request() {
    }

    public void setURIToCheck(String linkToCheck) throws URISyntaxException {
        this.linkToCheck = new URI(linkToCheck);
    }

    public int getHTTPStatusCodeFromResponse() throws IOException {
        return getHttpResponse().getStatusLine().getStatusCode();
    }

    private HttpResponse getHttpResponse() throws IOException {
        HttpClient client = initializeHttpClient();
        BasicHttpContext httpContext = new BasicHttpContext();
        if (driver != null) {
            addCookies(httpContext);
        }
        HttpRequestBase request = buildRequest();

        return client.execute(request, httpContext);
    }

    private HttpClient initializeHttpClient() {
        return HttpClientBuilder
                .create()
                .setRedirectStrategy(new LaxRedirectStrategy())
                .build();
    }

    private HttpRequestBase buildRequest() {
        HttpRequestBase requestMethod = new HttpGet();
        requestMethod.setURI(this.linkToCheck);

        return requestMethod;
    }

    private void addCookies(BasicHttpContext httpContext) {
        BasicCookieStore cookies = getCurrentDriverCookies(driver.manage().getCookies());
        httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookies);
    }

    private BasicCookieStore getCurrentDriverCookies(Set<Cookie> cookies) {
        BasicCookieStore mimicWebDriverCookieStore = new BasicCookieStore();
        for (Cookie seleniumCookie : cookies) {
            BasicClientCookie duplicateCookie = new BasicClientCookie(seleniumCookie.getName(), seleniumCookie.getValue());
            duplicateCookie.setDomain(seleniumCookie.getDomain());
            duplicateCookie.setSecure(seleniumCookie.isSecure());
            duplicateCookie.setExpiryDate(seleniumCookie.getExpiry());
            duplicateCookie.setPath(seleniumCookie.getPath());

            mimicWebDriverCookieStore.addCookie(duplicateCookie);
        }

        return mimicWebDriverCookieStore;
    }

    public File downloadFile() throws Exception {
        File downloadedFile = File.createTempFile("download", ".tmp");
        HttpResponse fileToDownload = getHttpResponse();
        FileUtils.copyInputStreamToFile(fileToDownload.getEntity().getContent(), downloadedFile);

        return downloadedFile;
    }
}
