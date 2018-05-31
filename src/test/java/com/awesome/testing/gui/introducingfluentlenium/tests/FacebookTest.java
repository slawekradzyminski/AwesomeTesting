package com.awesome.testing.gui.introducingfluentlenium.tests;

import com.awesome.testing.gui.introducingfluentlenium.pages.FacebookLoggedOutPage;
import com.awesome.testing.gui.introducingfluentlenium.pages.GroupApprovePage;
import com.awesome.testing.utils.MyProperties;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * See more at http://awesome-testing.com/2016/01/introducing-fluentlenium-1.html
 */
public class FacebookTest extends FluentTest {

    private MyProperties myProperties = new MyProperties();

    @Page
    private FacebookLoggedOutPage fbLogOutPage;

    @Page
    private GroupApprovePage groupApprovePage;

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver();
    }

    @Before
    public void authenticate() {
        fbLogOutPage.go();
        fbLogOutPage.login(myProperties.getProperty("email"), myProperties.getProperty("password"));
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

