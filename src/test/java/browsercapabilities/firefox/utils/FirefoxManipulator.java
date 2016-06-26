package browsercapabilities.firefox.utils;

import org.fluentlenium.adapter.FluentTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxManipulator extends FluentTestNg {

    private static final String PROFILE_DIRECTORY = "insert_your_path_here";

    @Override
    public WebDriver getDefaultDriver() {

        File profileDirectory = new File(PROFILE_DIRECTORY);
        FirefoxProfile profile = new FirefoxProfile(profileDirectory);
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("browser.startup.homepage", "www.google.pl");
        return new FirefoxDriver(profile);
    }
}
