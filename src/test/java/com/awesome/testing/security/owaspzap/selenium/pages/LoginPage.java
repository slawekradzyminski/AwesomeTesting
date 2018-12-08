package com.awesome.testing.security.owaspzap.selenium.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;

@PageUrl("http://localhost:8080/bodgeit/login.jsp")
public class LoginPage extends FluentPage {

    public void login(String username, String password) {
        el(By.id("username")).clear();
        el(By.id("username")).fill().with(username);
        el(By.id("password")).clear();
        el(By.id("password")).fill().with(password);
        el(By.id("submit")).click();
    }

}
