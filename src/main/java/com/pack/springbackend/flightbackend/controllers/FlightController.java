package com.pack.springbackend.flightbackend.controllers;

import com.pack.springbackend.flightbackend.models.Flight;
import com.pack.springbackend.flightbackend.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/user/flights")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("/user/flights/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Optional<Flight> getFlight(@PathVariable int id){
        return flightService.getFlight(id);
    }

    @PostMapping("/admin/flight")
    @PreAuthorize("hasRole('ADMIN')")
    public Flight createFlight(@RequestBody Flight flight){
        return flightService.createFlight(flight);
    }

    @DeleteMapping("/admin/flight/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteFlight(@PathVariable int id){
        flightService.deleteFlight(id);
    }

    @PutMapping("/admin/flight/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateFlight(@PathVariable int id,@RequestBody Flight flight) throws Exception {
        flightService.updateFlight(id, flight);
    }

    @GetMapping("/user/flights/search")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Flight> searchFlights(@RequestParam String origin, @RequestParam String destination) {
        return flightService.searchFlights(origin, destination);
    }
}
