package com.awesome.testing.api.juice.admin;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

        ResponseEntity<AdminRegisterResultDto> response = restTemplate.postForEntity("/api/Users", body, AdminRegisterResultDto.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getData().getIsAdmin()).isFalse();
    }

}
