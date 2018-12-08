package com.awesome.testing.security.owaspzap.securitytest;

import com.awesome.testing.security.owaspzap.api.ZapApi;
import com.awesome.testing.security.owaspzap.zap.Zap;
import org.junit.Test;
import org.zaproxy.clientapi.core.ClientApiException;

import static org.assertj.core.api.Assertions.assertThat;

public class SecurityTest {

    private static final String TARGET = "http://localhost:8080/bodgeit";

    private ZapApi zapApi = new ZapApi(TARGET);
    private Zap zap = new Zap(zapApi);

    @Test
    public void zapSecurityTest() throws ClientApiException, InterruptedException {
        zap.doSpidering();
        zap.doPassiveScan();
        zap.doActiveScan();

        zapApi.generateHtmlReport("report.html");

        assertThat(zapApi.getNumberOfAlerts()).isZero();
    }
}
