package com.pack.springbackend.flightbackend.services;
import com.pack.springbackend.flightbackend.models.User;
import com.pack.springbackend.flightbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findByRole("USER");
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
