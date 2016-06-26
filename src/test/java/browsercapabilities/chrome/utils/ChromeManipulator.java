package browsercapabilities.chrome.utils;

import org.fluentlenium.adapter.FluentTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChromeManipulator extends FluentTestNg {

    private static final String PREFS = "prefs";

    private static final String BROWSER_NOTIFICATIONS = "profile.managed_default_content_settings.notifications";
    private static final short DISABLED = 2;

    String START_FULLSCREEN = "start-fullscreen";
    String ALLOW_INSECURE_CONTENT = "allow-running-insecure-content";
    String INCOGNITO = "incognito";
    String IGNORE_CERTIFICATE_ERRORS = "--ignore-certificate-errors";

    @Override
    public WebDriver getDefaultDriver() {
        return new ChromeDriver(getChromeCapabilities());
    }

    private DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        return capabilities;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(getChromeSwitches());
        options.setExperimentalOption(PREFS, getChromePrefs());
        return options;
    }

    /**
     * Full list of available prefs - https://src.chromium.org/viewvc/chrome/trunk/src/chrome/common/pref_names.cc?view=markup
     *
     * @return prefs
     */
    private Map<String, Object> getChromePrefs() {
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put(BROWSER_NOTIFICATIONS, DISABLED);
        return chromePrefs;
    }

    /**
     * Full list of available switches - http://peter.sh/experiments/chromium-command-line-switches/
     *
     * @return switches List
     */
    private List<String> getChromeSwitches() {
        List<String> chromeSwitches = new ArrayList<>();
        chromeSwitches.add(INCOGNITO);
        chromeSwitches.add(ALLOW_INSECURE_CONTENT);
        chromeSwitches.add(IGNORE_CERTIFICATE_ERRORS);
        chromeSwitches.add(START_FULLSCREEN);
        return chromeSwitches;
    }

}
