
package com.routefinder.routefinder.service;
import org.springframework.jdbc.core.JdbcTemplate;

import com.routefinder.routefinder.graph.*;
import com.routefinder.routefinder.model.*;
import com.routefinder.routefinder.repository.RoadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RoadRepository roadRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RouteResponse findRoute(
            String source,
            String destination) {
                System.out.println("Database: " +
        jdbcTemplate.queryForObject("SELECT DATABASE()", String.class));

    System.out.println("Roads in DB: " +
        jdbcTemplate.queryForObject("SELECT COUNT(*) FROM roads", Integer.class));
        Graph graph = new Graph();

        
        System.out.println("Total Roads: " + roadRepository.count());

for (Road road : roadRepository.findAll()) {

    System.out.println(
        road.getSource() + " -> " +
        road.getDestination() + " : " +
        road.getDistance()
    );

    graph.addRoad(
        road.getSource(),
        road.getDestination(),
        road.getDistance()
    );
}

        long start = System.currentTimeMillis();

        DijkstraResult result =
                Dijkstra.findShortestPath(
                        graph,
                        source,
                        destination
                );

        long end = System.currentTimeMillis();

        return new RouteResponse(
                result.getDistance(),
                result.getPath(),
                end - start
        );
    }
}