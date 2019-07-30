package com.awesome.testing.api.juice.confidential;

public enum SecurityQuestion {

    GRANDMOTHER_NAME(6, "Paternal grandmother's first name?");

    private int id;
    private String question;

    SecurityQuestion(int id, String question) {
        this.id = id;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
