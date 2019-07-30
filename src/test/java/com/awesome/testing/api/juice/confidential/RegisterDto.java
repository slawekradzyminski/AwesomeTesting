package com.awesome.testing.api.juice.confidential;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class RegisterDto {

    private String email;
    private String password;
    private String passwordRepeat;
    private String securityAnswer;
    private SecurityQuestionDto securityQuestionDto;

    public RegisterDto(String email, String password) {
        this.email = email;
        this.password = password;
        this.passwordRepeat = password;
        this.securityAnswer = "answer";
        this.securityQuestionDto = new SecurityQuestionDto();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public SecurityQuestionDto getSecurityQuestionDto() {
        return securityQuestionDto;
    }

    class SecurityQuestionDto {

        private int id;
        private String securityQuestion;
        private String createdAt;
        private String updatedAt;

        SecurityQuestionDto() {
            this.id = SecurityQuestion.GRANDMOTHER_NAME.getId();
            this.securityQuestion = SecurityQuestion.GRANDMOTHER_NAME.getQuestion();
            this.createdAt = getCurrentTimestamp();
            this.updatedAt = getCurrentTimestamp();
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

        private String getCurrentTimestamp() {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
            return formatter.format(Instant.now());
        }

    }
}
