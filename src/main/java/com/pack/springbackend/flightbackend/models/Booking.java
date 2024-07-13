package com.pack.springbackend.flightbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    private LocalDate bookingDate;
    private boolean status;
    @ManyToOne
    @JsonBackReference("flight-bookings")
    private Flight flight;


    @ManyToOne
    @JsonBackReference("user-bookings")
    @JoinColumn(name = "user_id")
    private User user;
}
