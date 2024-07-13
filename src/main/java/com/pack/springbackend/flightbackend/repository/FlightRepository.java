package com.pack.springbackend.flightbackend.repository;

import com.pack.springbackend.flightbackend.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    List<Flight> findByOriginAndDestination(String origin, String destination);
}
