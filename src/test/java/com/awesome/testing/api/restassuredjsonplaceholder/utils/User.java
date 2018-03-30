package com.awesome.testing.api.restassuredjsonplaceholder.utils;

public class User {

    private int id;
    private final String title;
    private final String body;
    private final int userId;

    public User(int id, String title, String body, int userId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public User(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

}
