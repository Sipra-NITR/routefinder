package com.routefinder.routefinder.graph;

import java.util.List;

public class DijkstraResult {

    private int distance;
    private List<String> path;

    public DijkstraResult(int distance, List<String> path) {
        this.distance = distance;
        this.path = path;
    }

    public int getDistance() {
        return distance;
    }

    public List<String> getPath() {
        return path;
    }
}
