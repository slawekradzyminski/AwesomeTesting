package com.awesome.testing.security.xss.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@PageUrl("https://xss-game.appspot.com/level1/frame")
public class XssGameLevelOnePage extends FluentPage {

    @FindBy(id = "level1")
    private FluentWebElement body;

    @FindBy(id = "query")
    private FluentWebElement queryInput;

    @FindBy(id = "button")
    private FluentWebElement sarchButton;

    @Override
    public void isAt() {
        await().atMost(5, TimeUnit.SECONDS).until(body).displayed();
    }

    public void searchFor(String content) {
        queryInput.fill().with(content);
        sarchButton.click();
    }

    public boolean isAlertDisplayed() {
        boolean foundAlert;
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException e) {
            foundAlert = false;
        }
        return foundAlert;
    }

}
