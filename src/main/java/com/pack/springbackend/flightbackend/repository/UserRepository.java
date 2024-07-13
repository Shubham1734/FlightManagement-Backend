package com.pack.springbackend.flightbackend.repository;

import com.pack.springbackend.flightbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   public User findByUsername(String username);
   public List<User>findByRole(String role);
}
