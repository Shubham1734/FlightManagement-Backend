package com.pack.springbackend.flightbackend.controllers;
import com.pack.springbackend.flightbackend.models.Booking;
import com.pack.springbackend.flightbackend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Booking createBooking(@RequestParam int flightId,@RequestParam Long userid) {
        return bookingService.createBooking(flightId,userid);
    }
}
