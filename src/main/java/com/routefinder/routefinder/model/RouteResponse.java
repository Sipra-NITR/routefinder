package com.routefinder.routefinder.model;

import java.util.List;

public class RouteResponse {

    private int distance;
    private List<String> path;
    private long executionTime;

    public RouteResponse(
            int distance,
            List<String> path,
            long executionTime) {

        this.distance = distance;
        this.path = path;
        this.executionTime = executionTime;
    }

    public int getDistance() {
        return distance;
    }

    public List<String> getPath() {
        return path;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}