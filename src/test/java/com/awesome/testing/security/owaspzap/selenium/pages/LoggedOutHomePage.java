package com.awesome.testing.security.owaspzap.selenium.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;

@PageUrl("http://localhost:8080/bodgeit/")
public class LoggedOutHomePage extends FluentPage {

    public void crawlSiteToSimulateSeleniumTraffic() {
        el(By.linkText("Home")).click();
        el(By.linkText("Doodahs")).click();
        el(By.linkText("Zip a dee doo dah")).click();
        el(By.linkText("About Us")).click();
        el(By.linkText("Scoring page")).click();
        el(By.linkText("Your Basket")).click();
        el(By.linkText("Search")).click();
        el(By.name("q")).fill().with("test");
        el(By.cssSelector("input[type=\"submit\"]")).click();
        el(By.linkText("Search")).click();
        el(By.linkText("Advanced Search")).click();
        el(By.id("product")).fill().with("test");
        el(By.id("desc")).fill().with("test");
        el(By.id("type")).fill().with("test");
        el(By.id("price")).fill().with("test");
        el(By.cssSelector("input[type=\"submit\"]")).click();

    }

}