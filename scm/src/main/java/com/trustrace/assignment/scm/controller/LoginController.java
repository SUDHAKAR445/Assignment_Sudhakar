package com.trustrace.assignment.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustrace.assignment.scm.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    
    @GetMapping("/hello")
    public ResponseEntity<?> hello(HttpServletRequest req) {
        return ResponseEntity.ok(req.getHeader("Authorization").split(" ",2)[1]);
    }

    @GetMapping("/hai")
    public ResponseEntity<?> greet(HttpServletRequest req) {
        return ResponseEntity.ok("hello!");
    }

    @PostMapping("/{username}/{pwd}")
    public String login(@PathVariable String username, @PathVariable String pwd){
        return loginService.getToken(username,pwd);
    }
    @GetMapping("/validate/{username}")
    public ResponseEntity<String> tokenValidation(@RequestHeader("Authorization") String authorizationHeader,@PathVariable String username) {
        String token=loginService.extractToken(authorizationHeader);

        if (loginService.validateToken(token,username)) {
            return ResponseEntity.ok("Valid token");
        } 
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
    }

}
