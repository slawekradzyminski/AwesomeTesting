package com.awesome.testing.security.owaspzap.selenium;

import com.awesome.testing.security.owaspzap.selenium.pages.LoggedInHomePage;
import com.awesome.testing.security.owaspzap.selenium.pages.LoggedOutHomePage;
import com.awesome.testing.security.owaspzap.selenium.pages.LoginPage;
import com.awesome.testing.security.owaspzap.selenium.pages.RegisterPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;


public class BadgeItCrawlTest extends ChromeProxyConfig {

    private static final String USERNAME = "AwesomeTesting@blogspot.com";
    private static final String PASSWORD = "AwesomeTesting";

    @Page
    private RegisterPage registerPage;

    @Page
    private LoggedOutHomePage loggedOutHomePage;

    @Page
    private LoggedInHomePage loggedInHomePage;

    @Page
    private LoginPage loginPage;

    @Test
    public void loggedOutCrawl() {
        goTo(loggedOutHomePage).crawlSiteToSimulateSeleniumTraffic();
    }

    @Test
    public void loggedInCrawl() {
        goTo(registerPage).registerUser(USERNAME, PASSWORD);
        goTo(loginPage).login(USERNAME, PASSWORD);
        goTo(loggedInHomePage).crawlPageToSimulateSeleniumTraffic();
    }

}