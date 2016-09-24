package gui.introducingfluentlenium.pages;

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
        await().until(APPROVE_ALL_BUTTON).isPresent();
    }

    public void approveAll() {
        find(APPROVE_ALL_BUTTON).first().click();
    }

    public void confirm() {
        await().until(CONFIRM_APPROVAL_BUTTON).isPresent();
        findFirst(CONFIRM_APPROVAL_BUTTON).click();
    }

}
