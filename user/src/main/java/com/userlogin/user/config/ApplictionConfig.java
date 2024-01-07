package com.userlogin.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.RequiredArgsConstructor;
import repository.UserRepository;

@Configuration
@RequiredArgsConstructor
public class ApplictionConfig {

    @Autowired
    private final UserRepository repository;
    @Bean
    public UserDetailsService userDetailsService()
    {
         return username -> repository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
