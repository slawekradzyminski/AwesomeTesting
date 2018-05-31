package com.awesome.testing.gui.seleniumvsfluentlenium.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PostPage extends PageObject {

    @FindBy(id = "comment-editor")
    private WebElement commentsSection;

    public PostPage(WebDriver driver) {
        super(driver);
    }

    public void isInitialized() {
        assertThat(commentsSection.isDisplayed()).isTrue();
    }

    public void checkComments() {
        driver.switchTo().frame(commentsSection);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("commentBody")));
    }

    private Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(5, TimeUnit.SECONDS)
            .pollingEvery(500, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class)
            .withMessage("Oops, element didn't appear!");

}