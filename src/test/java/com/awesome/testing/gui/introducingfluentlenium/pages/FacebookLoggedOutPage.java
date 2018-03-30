package com.awesome.testing.gui.introducingfluentlenium.pages;

import org.fluentlenium.core.FluentPage;

public class FacebookLoggedOutPage extends FluentPage {

    @Override
    public String getUrl() {
        return "https://www.facebook.com";
    }

    private static final String WAITER_SELECTOR_AFTER_LOGIN = ".mentionsTextarea";
    private static final String LOGIN_FIELD = "#email";
    private static final String PASS_FIELD = "#pass";
    private static final String SIGN_IN_BUTTON = "#loginbutton";

    public void login(String email, String password) {
        el(LOGIN_FIELD).fill().with(email);
        el(PASS_FIELD).fill().with(password);
        find(SIGN_IN_BUTTON).first().click();
    }

    public void verifySuccessfulLogin() {
        await().until(el(WAITER_SELECTOR_AFTER_LOGIN)).displayed();
    }

}
