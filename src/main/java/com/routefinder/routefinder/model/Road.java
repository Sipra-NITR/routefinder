package com.routefinder.routefinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roads")
public class Road {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String source;
    private String destination;
    private int distance;

    public Road() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}