package com.pack.springbackend.flightbackend.repository;

import com.pack.springbackend.flightbackend.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
