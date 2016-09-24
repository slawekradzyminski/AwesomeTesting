package gui.introducingfluentlenium.pages;

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
        fill(LOGIN_FIELD).with(email);
        fill(PASS_FIELD).with(password);
        find(SIGN_IN_BUTTON).first().click();
    }

    public void verifySuccessfulLogin() {
        await().until(WAITER_SELECTOR_AFTER_LOGIN).areDisplayed();
    }

}
