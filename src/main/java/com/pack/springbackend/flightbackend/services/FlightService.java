package com.pack.springbackend.flightbackend.services;

import com.pack.springbackend.flightbackend.models.Flight;
import com.pack.springbackend.flightbackend.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlight(int id){
        return flightRepository.findById(id);

    }
    public Flight createFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public void deleteFlight(int id){
        flightRepository.deleteById(id);
    }

    public void updateFlight(int id,Flight newFlightDetails) throws Exception {
        Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() -> new Exception("Flight not found with id " + id));
        existingFlight.setOrigin(newFlightDetails.getOrigin());
        existingFlight.setDestination(newFlightDetails.getDestination());
        existingFlight.setDepartureTime(newFlightDetails.getDepartureTime());
        existingFlight.setArrivalTime(newFlightDetails.getArrivalTime());
        existingFlight.setPrice(newFlightDetails.getPrice());
        flightRepository.save(existingFlight);
    }

    public List<Flight> searchFlights(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }
}
