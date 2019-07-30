package com.awesome.testing.api.juice.admin;

import com.google.common.base.MoreObjects;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;

public class AdminRegisterDto {

    private String email;
    private String password;
    private boolean isAdmin;

    public AdminRegisterDto() {
        this.email = randomAlphabetic(10);
        this.password = randomAlphabetic(10);
        this.isAdmin = true;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("email", email)
                .add("password", password)
                .add("isAdmin", isAdmin)
                .toString();
    }
}
