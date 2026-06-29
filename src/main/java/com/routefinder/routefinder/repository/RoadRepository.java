package com.routefinder.routefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.routefinder.routefinder.model.Road;


public interface RoadRepository
        extends JpaRepository<Road, Integer> {
}