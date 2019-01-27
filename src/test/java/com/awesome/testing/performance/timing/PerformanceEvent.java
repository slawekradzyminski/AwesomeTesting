package com.awesome.testing.performance.timing;

/**
 * See <a href="https://www.w3.org/TR/navigation-timing/#dom-performancetiming-interface">
 *     Navigation Timing spec</a>
 *     for more events and description
 */
public enum PerformanceEvent {

    LOAD_EVENT_END ("loadEventEnd"),
    NAVIGATION_START ("navigationStart");

    private final String event;

    PerformanceEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return this.event;
    }
}