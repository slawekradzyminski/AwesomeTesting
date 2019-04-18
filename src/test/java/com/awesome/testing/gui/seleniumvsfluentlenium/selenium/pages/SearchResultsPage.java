package com.awesome.testing.gui.seleniumvsfluentlenium.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends PageObject {

    @FindBy(className = "status-msg-wrap")
    private WebElement searchOptionPanel;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage isInitialized() {
        assertThat(searchOptionPanel.isDisplayed()).isTrue();
        return this;
    }

    public SearchResultsPage assertThatPostsAreDisplayed() {
        List<WebElement> postsTitles = driver.findElements(By.cssSelector("h1 a"));
        assertThat(postsTitles).size().isPositive();
        return this;
    }

    public PostPage clickOnFirstPost() {
        List<WebElement> posts = driver.findElements(By.cssSelector("h1 a"));
        posts.get(0).click();

        return new PostPage(driver);
    }

}