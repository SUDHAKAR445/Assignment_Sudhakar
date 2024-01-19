package com.sudhakar.library.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhakar.library.authentication.model.Token;

import lombok.Builder;
import lombok.Data;

public interface TokenRepository extends JpaRepository<Token, Long> {
    
}
