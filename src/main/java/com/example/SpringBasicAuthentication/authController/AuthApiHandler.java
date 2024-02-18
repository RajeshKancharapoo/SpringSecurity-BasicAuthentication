package com.example.SpringBasicAuthentication.authController;


import com.example.SpringBasicAuthentication.modelDTO.UserDTO;
import com.example.SpringBasicAuthentication.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthApiHandler {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("register")
    public ResponseEntity<String>addUser(@RequestBody UserDTO userDTO){
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepo.save(userDTO);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }


}
