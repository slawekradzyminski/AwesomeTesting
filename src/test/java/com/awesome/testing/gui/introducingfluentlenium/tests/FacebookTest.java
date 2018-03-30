package com.awesome.testing.gui.introducingfluentlenium.tests;

import com.awesome.testing.gui.introducingfluentlenium.pages.FacebookLoggedOutPage;
import com.awesome.testing.gui.introducingfluentlenium.pages.GroupApprovePage;
import com.awesome.testing.gui.introducingfluentlenium.utils.LoadProperties;
import org.fluentlenium.adapter.testng.FluentTestNg;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * See more at http://awesome-testing.com/2016/01/introducing-fluentlenium-1.html
 */
public class FacebookTest extends FluentTestNg {

    private LoadProperties properties = new LoadProperties();

    @Page
    private FacebookLoggedOutPage fbLogOutPage;

    @Page
    private GroupApprovePage groupApprovePage;

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver();
    }

    @BeforeMethod
    public void authenticate() {
        fbLogOutPage.go();
        fbLogOutPage.login(properties.getProperty("email"), properties.getProperty("password"));
        fbLogOutPage.verifySuccessfulLogin();
    }

    @Test
    public void acceptAllPokemons() {
        groupApprovePage.go();
        groupApprovePage.isAt();
        groupApprovePage.approveAll();
        groupApprovePage.confirm();
    }

}

