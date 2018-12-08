package com.awesome.testing.security.owaspzap.selenium.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("http://localhost:8080/bodgeit/register.jsp")
public class RegisterPage extends FluentPage {

    @FindBy(id = "username")
    private FluentWebElement usernameField;

    @FindBy(id = "password1")
    private FluentWebElement passwordField;

    @FindBy(id = "password2")
    private FluentWebElement repeatPasswordField;

    @FindBy(id = "submit")
    private FluentWebElement submitButton;

    public void registerUser(String username, String password) {
        usernameField.fill().with(username);
        passwordField.fill().with(password);
        repeatPasswordField.fill().with(password);
        submitButton.click();
    }

}
