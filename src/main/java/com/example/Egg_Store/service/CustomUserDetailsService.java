package com.example.Egg_Store.service;

import com.example.Egg_Store.model.User;
import com.example.Egg_Store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username).orElseThrow( ()-> new UsernameNotFoundException("User not Found!!") );

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),  new ArrayList<>());
    }
}
