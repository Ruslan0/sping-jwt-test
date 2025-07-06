package com.rsn.user.accounts.dto;

public record UserResponseWithCredentials(UserResponse userResponse, String passwordHash) {}