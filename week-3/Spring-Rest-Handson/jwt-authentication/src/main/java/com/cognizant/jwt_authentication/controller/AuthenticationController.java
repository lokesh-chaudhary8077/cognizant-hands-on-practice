package com.cognizant.jwt_authentication.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwt_authentication.model.JwtResponse;
import com.cognizant.jwt_authentication.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public JwtResponse authenticate(HttpServletRequest request) {

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        String base64Credentials = authorizationHeader.substring("Basic ".length());

        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);

        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        String username = credentials.split(":")[0];

        String token = jwtUtil.generateToken(username);

        return new JwtResponse(token);
    }
}