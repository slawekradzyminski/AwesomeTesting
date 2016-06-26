package introducingfluentlenium.tests;

import introducingfluentlenium.pages.FacebookLoggedOutPage;
import introducingfluentlenium.pages.GroupApprovePage;
import introducingfluentlenium.utils.LoadProperties;
import org.fluentlenium.adapter.FluentTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * See more at http://awesome-testing.blogspot.com/2016/01/introducing-fluentlenium-1.html
 */
public class FacebookTest extends FluentTestNg {

    private static final String EMAIL = LoadProperties.loadProperty("email");
    private static final String PASSWORD = LoadProperties.loadProperty("password");

    @Override
    public WebDriver getDefaultDriver() {
        return new ChromeDriver();
    }

    @BeforeMethod
    public void authenticate() {
        FacebookLoggedOutPage fbLogOutPage = createPage(FacebookLoggedOutPage.class);
        fbLogOutPage.go();
        fbLogOutPage.login(EMAIL, PASSWORD);
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

