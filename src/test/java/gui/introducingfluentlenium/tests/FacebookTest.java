package gui.introducingfluentlenium.tests;

import gui.introducingfluentlenium.pages.FacebookLoggedOutPage;
import gui.introducingfluentlenium.pages.GroupApprovePage;
import gui.introducingfluentlenium.utils.LoadProperties;
import org.fluentlenium.adapter.FluentTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * See more at http://awesome-testing.blogspot.com/2016/01/introducing-fluentlenium-1.html
 */
public class FacebookTest extends FluentTestNg {

    private LoadProperties properties = new LoadProperties();

    @Override
    public WebDriver getDefaultDriver() {
        return new ChromeDriver();
    }

    @BeforeMethod
    public void authenticate() {
        FacebookLoggedOutPage fbLogOutPage = createPage(FacebookLoggedOutPage.class);
        fbLogOutPage.go();
        fbLogOutPage.login(properties.getProperty("email"), properties.getProperty("password"));
        fbLogOutPage.verifySuccessfulLogin();
    }

    @Test
    public void acceptAllPokemons() {
        GroupApprovePage groupApprovePage = createPage(GroupApprovePage.class);
        groupApprovePage.go();
        groupApprovePage.isAt();
        groupApprovePage.approveAll();
        groupApprovePage.confirm();
    }

}

