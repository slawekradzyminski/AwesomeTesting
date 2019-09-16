package com.awesome.testing.api.juice.admin;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AdminAccessTest {

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:3000"));
    }

    @Test
    public void shouldNotBeAbleToRegisterAsAdmin() {
        AdminRegisterDto adminRegisterDto = new AdminRegisterDto();
        JSONObject jsonObj = new JSONObject(adminRegisterDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> body = new HttpEntity<>(jsonObj.toString(), headers);

        assertThatThrownBy(
                () -> restTemplate.postForEntity("/api/Users", body, AdminRegisterResultDto.class))
                .isInstanceOf(HttpClientErrorException.class)
                .hasMessageContaining("401 Unauthorized");
    }

}
