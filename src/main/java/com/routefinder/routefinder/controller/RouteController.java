package com.routefinder.routefinder.controller;

import com.routefinder.routefinder.model.RouteResponse;
import com.routefinder.routefinder.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/route")
    public RouteResponse getRoute(

            @RequestParam String source,

            @RequestParam String destination) {

        return routeService.findRoute(
                source,
                destination
        );
    }
}