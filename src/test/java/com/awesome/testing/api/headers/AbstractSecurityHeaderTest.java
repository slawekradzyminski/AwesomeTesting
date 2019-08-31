package com.awesome.testing.api.headers;

import com.google.common.collect.ImmutableList;

import java.util.List;

abstract class AbstractSecurityHeaderTest {

    static final List<String> CHECKED_URLS = ImmutableList.of(
            "https://www.awesome-testing.com",
            "https://www.awesome-testing.com/search/label/security",
            "https://www.awesome-testing.com/2019/06/throttling-network-in-selenium-tests.html",
            "https://www.awesome-testing.com/2017/"
    );

}
