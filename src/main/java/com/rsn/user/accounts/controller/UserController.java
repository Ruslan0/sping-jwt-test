package com.rsn.user.accounts.controller;

import com.rsn.user.accounts.dto.UserParamsDto;
import com.rsn.user.accounts.security.JwtService;
import com.rsn.user.accounts.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pioneer/users")
public class UserController {
    private final UserService userService;
    @Autowired
    JwtService jwtUtils;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @PreAuthorize("permitAll()")
    @PostMapping("create")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserParamsDto userParamsDto) {
        Long userId = userService.createUser(userParamsDto);
        if (userId > 0) {
            return ResponseEntity.ok(String.format("User registered successfully with id = %s , \n token = %s", userId,  jwtUtils.generateToken(userParamsDto.getName())));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username is already taken!");
        }
    }

}
