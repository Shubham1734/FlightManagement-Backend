package com.pack.springbackend.flightbackend.models;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
}
