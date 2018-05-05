package com.awesome.testing.utils;

import java.io.IOException;

public class Properties {

    private java.util.Properties properties;

    public Properties() {
        properties = loadProperties();
    }

    private static java.util.Properties loadProperties() {
        java.util.Properties properties = new java.util.Properties();
        try {
            properties.load(Properties.class.getResourceAsStream("/user.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;

    }

    public String getProperty (String property) {
        return properties.getProperty(property);
    }

}