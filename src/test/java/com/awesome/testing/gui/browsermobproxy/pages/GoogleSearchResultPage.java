package com.awesome.testing.gui.browsermobproxy.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class GoogleSearchResultPage extends FluentPage {

    @Override
    public void isAt() {
        await().atMost(5, TimeUnit.SECONDS).until(el(By.linkText("Awesome Testing"))).displayed();
    }

    public AwesomeTestingPage clickLink(String linkToClick) {
        el(By.linkText(linkToClick)).click();
        return newInstance(AwesomeTestingPage.class);
    }

}
