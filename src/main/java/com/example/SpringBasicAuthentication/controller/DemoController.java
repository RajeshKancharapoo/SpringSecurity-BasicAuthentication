package com.example.SpringBasicAuthentication.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {

    @GetMapping("all")
    public ResponseEntity<String>m1(){
        return new ResponseEntity<>("This is secured endpoint both user and admin can access it", HttpStatus.OK);
    }

    @GetMapping("admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String>adminEndpoint(){
        return new ResponseEntity<>("This is secured endpoint only admin can access it",HttpStatus.OK);
    }

    @GetMapping("user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String>userEndpoint(){
        return new ResponseEntity<>("This is secured endpoint only user can access it",HttpStatus.OK);
    }
}
