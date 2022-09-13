package com.challenge.Auth.controller;

import com.challenge.Auth.dto.UserDTO;
import com.challenge.Auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    private UserDetailsCustomService userDetailsCustomService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @Autowired
    public UserAuthController(
        UserDetailsCustomService userDetailsCustomService,
        AuthenticationManager authenticationManager,
        JwtUtils jwtUtils){
        this.userDetailsCustomService=userDetailsCustomService;
        this.authenticationManager=authenticationManager;
        this.jwtUtils=jwtUtils;
    }

    @PostMapping("/singup")
    public ResponseEntity<AuthenticationResponse> signUo(@Valid @RequestBody UserDTO user) throws

}
