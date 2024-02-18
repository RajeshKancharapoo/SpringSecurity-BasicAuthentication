package com.example.SpringBasicAuthentication.entity;

import com.example.SpringBasicAuthentication.modelDTO.UserDTO;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class UserInfo implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority>role;

    public UserInfo(UserDTO userDTO){
        username=userDTO.getUsername();
        password=userDTO.getPassword();
        role=new ArrayList<>();
        role.add(new SimpleGrantedAuthority("ROLE_"+userDTO.getRole().toString()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
