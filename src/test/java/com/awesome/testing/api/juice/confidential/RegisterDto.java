package com.awesome.testing.api.juice.confidential;

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
}
