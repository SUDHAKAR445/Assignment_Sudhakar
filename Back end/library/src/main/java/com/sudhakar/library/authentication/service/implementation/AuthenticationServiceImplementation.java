package com.sudhakar.library.authentication.service.implementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sudhakar.library.authentication.dto.AuthenticationRequest;
import com.sudhakar.library.authentication.dto.AuthenticationResponse;
import com.sudhakar.library.authentication.dto.RegisterRequest;
import com.sudhakar.library.authentication.service.AuthenticationService;
import com.sudhakar.library.authentication.service.JwtService;
import com.sudhakar.library.entity.Role;
import com.sudhakar.library.entity.User;
import com.sudhakar.library.exception.DuplicateUserException;
import com.sudhakar.library.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImplementation implements AuthenticationService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public ResponseEntity<AuthenticationResponse> register(RegisterRequest request) {
                User user = User.builder()
                                .firstName(request.getFirstName())
                                .lastName(request.getLastName())
                                .email(request.getEmail())
                                .username(request.getUsername())
                                .role(request.getRole())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .build();

                if (user.getEmail().endsWith("admin@gmail.com") && user.getUsername().endsWith("_admin")) {
                        user.setRole(Role.ADMIN);
                } else if (user.getEmail().endsWith("librarian@gmail.com")
                                && user.getUsername().endsWith("_librarian")) {
                        user.setRole(Role.LIBRARIAN);
                }
                user.setRole(Role.MEMBER);

                try {
                        if (userRepository.existsByUsernameOrEmail(user.getUsername(), user.getEmail())) {
                                throw new DuplicateUserException("Username or email already exists.");
                        }
                        userRepository.save(user);
                } catch (DuplicateUserException e) {
                        return new ResponseEntity<>(HttpStatus.CONFLICT);
                } catch (Exception e) {
                        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }

                var jwtToken = jwtService.generateToken(user);
                return new ResponseEntity<>(AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build(), HttpStatus.OK);
        }

        public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));

                var user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new UsernameNotFoundException("Email id or Password invalid"));

                var jwtToken = jwtService.generateToken(user);
                return new ResponseEntity<>(AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build(), HttpStatus.OK);
        }

}
