package com.routefinder.routefinder.service;

import com.routefinder.routefinder.graph.*;
import com.routefinder.routefinder.model.*;
import com.routefinder.routefinder.repository.RoadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RoadRepository roadRepository;

    public RouteResponse findRoute(
            String source,
            String destination) {

        Graph graph = new Graph();

        for(Road road : roadRepository.findAll()) {

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