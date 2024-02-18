package com.example.SpringBasicAuthentication.service;

import com.example.SpringBasicAuthentication.entity.UserInfo;
import com.example.SpringBasicAuthentication.modelDTO.UserDTO;
import com.example.SpringBasicAuthentication.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDTO>user=userRepo.findByUsername(username);
        return user.map(UserInfo::new).orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}
