package browsercapabilities.firefox.utils;

import org.fluentlenium.adapter.FluentTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxManipulator extends FluentTestNg {

    private static final String PROFILE_DIRECTORY = "insert_your_path_here";

    private static final String HOMEPAGE_KEY = "browser.startup.homepage";
    private static final String HOMEPAGE_VALUE = "www.google.pl";

    @Override
    public WebDriver getDefaultDriver() {

        File profileDirectory = new File(PROFILE_DIRECTORY);
        FirefoxProfile profile = new FirefoxProfile(profileDirectory);
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference(HOMEPAGE_KEY, HOMEPAGE_VALUE);

        return new FirefoxDriver(profile);
    }
}
