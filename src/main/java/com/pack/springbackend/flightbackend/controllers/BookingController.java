package com.pack.springbackend.flightbackend.controllers;
import com.pack.springbackend.flightbackend.models.Booking;
import com.pack.springbackend.flightbackend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/user/bookings")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Booking createBooking(@RequestParam int flightId,@RequestParam Long userid) {
        return bookingService.createBooking(flightId,userid);
    }

    @GetMapping("/admin/bookings")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/user/bookings/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void deletebooking(@PathVariable int id){
        bookingService.deletebooking(id);
    }

}
