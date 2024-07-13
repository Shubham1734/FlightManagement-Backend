package com.pack.springbackend.flightbackend.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;
    private String phone;

    private String role;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-bookings")
    private List<Booking> bookings;
}
