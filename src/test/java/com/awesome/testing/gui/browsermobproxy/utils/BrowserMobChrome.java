package com.awesome.testing.gui.browsermobproxy.utils;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserMobChrome extends FluentTest {

    private static final int BROWSER_MOB_PROXY_PORT = 9191;

    protected BrowserMobProxyServer server;

    @Before
    public void startBMP() {
        server = new BrowserMobProxyServer();
        server.start(BROWSER_MOB_PROXY_PORT);
        server.setHarCaptureTypes(CaptureType.getHeaderCaptureTypes());
    }

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver(getChromeCapabilities());
    }

    private DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.PROXY, getChromeProxySettings());
        return capabilities;
    }

    private Proxy getChromeProxySettings() {
        return ClientUtil.createSeleniumProxy(server);
    }

    @After
    public void stopBMP() {
        server.stop();
    }
}
