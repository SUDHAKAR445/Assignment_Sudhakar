package com.trustrace.assignment.scm.service;
public interface LoginService {
    public String getToken(String username,String pwd);
    public String extractToken(String authorizationHeader);
    public boolean validateToken(String token,String username);
}
