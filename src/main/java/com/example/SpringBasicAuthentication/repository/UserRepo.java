package com.example.SpringBasicAuthentication.repository;

import com.example.SpringBasicAuthentication.modelDTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserDTO,Integer> {

    Optional<UserDTO>findByUsername(String username);
}
