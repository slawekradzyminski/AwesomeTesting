package com.awesome.testing.gui.headless;

import com.awesome.testing.gui.seleniumvsfluentlenium.selenium.pages.MainPage;
import com.awesome.testing.utils.MyProperties;
import org.openqa.selenium.WebDriver;

abstract class AbstractHeadlessTest {

    MyProperties myProperties = new MyProperties();

    void shouldSuccessfullyFindPostAndDisplayCommentsSection(WebDriver driver) {
        driver.get("https://www.awesome-testing.com");

        new MainPage(driver)
                .searchFor("public speaking")
                .assertThatPostsAreDisplayed()
                .clickOnFirstPost()
                .assertThatCommentSectionIsDisplayed();
    }
}