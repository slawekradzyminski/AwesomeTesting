package com.awesome.testing.security.owaspzap.selenium.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;

@PageUrl("http://localhost:8080/bodgeit/")
public class LoggedInHomePage extends FluentPage {

    public void crawlPageToSimulateSeleniumTraffic() {
        el(By.linkText("Doodahs")).click();
        el(By.linkText("Zip a dee doo dah")).click();
        el(By.id("submit")).click();
    }

}
