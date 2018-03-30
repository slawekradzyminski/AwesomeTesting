package com.awesome.testing.gui.introducingfluentlenium.pages;

import org.fluentlenium.core.FluentPage;

public class GroupApprovePage extends FluentPage {

    private static final String APPROVE_ALL_BUTTON = "[rel=async-post]";
    private static final String CONFIRM_APPROVAL_BUTTON = ".layerConfirm";

    @Override
    public String getUrl() {
        return "https://www.facebook.com/groups/booksIT/requests/?notif_t=group_r2j";
    }

    @Override
    public void isAt() {
        await().until(el(APPROVE_ALL_BUTTON)).present();
    }

    public void approveAll() {
        find(APPROVE_ALL_BUTTON).first().click();
    }

    public void confirm() {
        await().until(el(CONFIRM_APPROVAL_BUTTON)).present();
        el(CONFIRM_APPROVAL_BUTTON).click();
    }

}
