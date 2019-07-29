package com.awesome.testing.api.juice.confidential;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class SecurityQuestionDto {

    private int id;
    private String securityQuestion;
    private String createdAt;
    private String updatedAt;

    SecurityQuestionDto() {
        this.id = 6;
        this.securityQuestion = SecurityQuestion.GRANDMOTHER_NAME.value();
        this.createdAt = getNow();
        this.updatedAt = getNow();
    }

    public int getId() {
        return id;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    private String getNow() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        return formatter.format(Instant.now());
    }

    enum SecurityQuestion {
        GRANDMOTHER_NAME("Paternal grandmother's first name?");

        private String question;

        SecurityQuestion(String question) {
            this.question = question;
        }

        public String value() {
            return question;
        }
    }

}
