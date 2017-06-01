package gui.selectors.tests;

import gui.selectors.pages.HomePage;
import org.fluentlenium.adapter.testng.FluentTestNg;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * See more at http://www.awesome-testing.com/2017/05/how-to-find-test-cssselector-using.html
 */
public class BlogTest extends FluentTestNg {

    private static final int EXPECTED_NUMBER_OF_POSTS = 5;

    @Page
    private HomePage homePage;

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver();
    }

    @Test
    public void shouldDisplayHeader() {
        homePage.go();
        homePage.assertThatHeaderIsDisplayed();
    }

    @Test
    public void shouldBeFivePosts() {
        homePage.go();
        homePage.assertThatNumberOfTitlesEquals(EXPECTED_NUMBER_OF_POSTS);
    }

}
