package com.rsn.user.accounts.service;

import com.rsn.user.accounts.dto.SearchParamsDto;
import com.rsn.user.accounts.dto.UserResponse;
import com.rsn.user.accounts.dto.UserParamsDto;
import com.rsn.user.accounts.dto.UserResponseWithCredentials;

import java.util.List;

public interface UserService {
    Long createUser(UserParamsDto userParamsDto);
    List<UserResponse> findUsersByParams(SearchParamsDto params);
    UserResponseWithCredentials getUserCredentialsByUsername(String username);
}
