package com.awesome.testing.performance.timing;

public enum PerformanceEvent {

    LOAD_EVENT_END ("loadEventEnd"),
    NAVIGATION_START ("navigationStart");

    private final String name;

    PerformanceEvent(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}