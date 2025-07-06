package com.rsn.user.accounts.controller;


import com.rsn.user.accounts.entities.User;
import com.rsn.user.accounts.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/pioneer")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;
    @PostMapping("/signin")
    public String authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getName(),
                        user.getPassword()
                )
        );
        return jwtService.generateToken(authentication.getPrincipal().toString());
    }
}