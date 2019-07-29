package com.awesome.testing.api.juice.confidential;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccessingConfidentialDocumentTest {

    private static final String PASSWORD = "awesometesting";

    private final String validLogin = String.format("automated%s@awesome.com", randomAlphanumeric(6));
    private final String invalidLogin = "awesome@testing.com";
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:3000"));

        registerUser(validLogin);
    }

    private void registerUser(String login) {
        RegisterDto registerDto = new RegisterDto(login, PASSWORD);
        HttpEntity<RegisterDto> body = new HttpEntity<>(registerDto);
        restTemplate.exchange("/api/Users", HttpMethod.POST, body, String.class);
    }

    @Test
    public void shouldBeAbleToLogin() {
        LoginDto loginDto = new LoginDto(validLogin, PASSWORD);
        HttpEntity<LoginDto> body = new HttpEntity<>(loginDto);
        ResponseEntity<String> result = restTemplate.postForEntity("/rest/user/login", body, String.class);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldBeAbleToBeAbleToRegisterSameUserTwice() {
        assertThatThrownBy(() -> registerUser(validLogin))
                .isInstanceOf(HttpClientErrorException.class)
                .hasMessageContaining("400 Bad Request");
    }

    @Test
    public void shouldNotCauseServerSideError() {
        LoginDto loginDto = new LoginDto("'", PASSWORD);
        HttpEntity<LoginDto> body = new HttpEntity<>(loginDto);
        ResponseEntity<String> result = restTemplate.postForEntity("/rest/user/login", body, String.class);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
