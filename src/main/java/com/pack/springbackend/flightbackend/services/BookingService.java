package com.pack.springbackend.flightbackend.services;

import com.pack.springbackend.flightbackend.models.Booking;
import com.pack.springbackend.flightbackend.models.Flight;
import com.pack.springbackend.flightbackend.models.User;
import com.pack.springbackend.flightbackend.repository.BookingRepository;
import com.pack.springbackend.flightbackend.repository.FlightRepository;
import com.pack.springbackend.flightbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking createBooking(int flightId, Long userId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setUser(user);
        booking.setBookingDate(LocalDate.now());
        booking.setStatus(true);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deletebooking(int id){
        bookingRepository.deleteById(id);
    }
}
