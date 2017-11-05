package gui.headlessfirefox.utils;

import org.apache.commons.lang3.SystemUtils;
import org.fluentlenium.adapter.testng.FluentTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class FirefoxManipulator extends FluentTestNg {

    private static final String MY_GECKO_PATH = "C:\\drivers\\geckodriver.exe";

    @BeforeTest
    public void setUp() {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.gecko.driver", MY_GECKO_PATH);
        }
    }

    @Override
    public WebDriver newWebDriver() {
        return new FirefoxDriver(getFirefoxCapabilities());
    }

    private DesiredCapabilities getFirefoxCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());
        return capabilities;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return options;
    }
}
