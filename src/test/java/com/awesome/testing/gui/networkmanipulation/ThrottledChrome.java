package com.awesome.testing.gui.networkmanipulation;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class ThrottledChrome extends FluentTest {

    private static final int BROWSER_MOB_PROXY_PORT = 9191;
    private static final String USER_AGENT = "User-Agent";

    protected BrowserMobProxyServer server = new BrowserMobProxyServer();

    @Before
    public void startBMP() {
        server.start(BROWSER_MOB_PROXY_PORT);
        server.setReadBandwidthLimit(1000000);
        server.setWriteBandwidthLimit(1000000);
        server.setLatency(300, TimeUnit.MILLISECONDS);

        server.removeHeader(USER_AGENT);
        server.addHeader(USER_AGENT, "Throttled Chrome Selenium Test");
    }

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setProxy(getProxy());
        return options;
    }

    private Proxy getProxy() {
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(server);
        String hostIp = null;
        try {
            hostIp = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String proxyUrl = String.format("%s:%s", hostIp, BROWSER_MOB_PROXY_PORT);
        seleniumProxy.setHttpProxy(proxyUrl);
        seleniumProxy.setSslProxy(proxyUrl);

        return seleniumProxy;
    }

    @After
    public void stopBMP() {
        server.stop();
    }
}
