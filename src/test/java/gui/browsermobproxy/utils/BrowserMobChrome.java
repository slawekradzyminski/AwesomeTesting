package gui.browsermobproxy.utils;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.fluentlenium.adapter.FluentTestNg;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrowserMobChrome extends FluentTestNg {

    private static final int BROWSER_MOB_PROXY_PORT = 9191;

    protected BrowserMobProxyServer server;

    @BeforeClass
    public void startBMP() {
        server = new BrowserMobProxyServer();
        server.start(BROWSER_MOB_PROXY_PORT);
        server.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
    }

    @Override
    public WebDriver getDefaultDriver() {
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

    @AfterClass
    public void stopBMP() {
        server.stop();
    }
}
