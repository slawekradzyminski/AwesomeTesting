package com.awesome.testing.api.juice.openredirect;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OpenRedirectTest {

    private static final String REDIRECTION_URL = "https://awesome-testing.com";
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:3000"));
    }

    @Test
    public void shouldNotFollowRedirect() {
        assertThatThrownBy(() -> restTemplate.getForEntity(getRedirectionUrl(), String.class))
                .isInstanceOf(HttpClientErrorException.class)
                .hasMessageContaining("406 Not Acceptable");
    }

    @Test
    public void shouldNotFollowRedirectWithWhitelistedUrl() {
        assertThatThrownBy(() -> restTemplate.getForEntity(getRedirectionUrlWithWhitelistedUrl(), String.class))
                .isInstanceOf(HttpClientErrorException.class)
                .hasMessageContaining("406 Not Acceptable");
    }

    private String getRedirectionUrl() {
        return String.format("/redirect?to=%s", REDIRECTION_URL);
    }

    private String getRedirectionUrlWithWhitelistedUrl() {
        return String.format("/redirect?to=%s?pwned=https://github.com/bkimminich/juice-shop", REDIRECTION_URL);
    }

}
