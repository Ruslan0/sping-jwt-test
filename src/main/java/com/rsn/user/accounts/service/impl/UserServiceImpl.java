package com.rsn.user.accounts.service.impl;

import com.rsn.user.accounts.dto.*;
import com.rsn.user.accounts.entities.*;
import com.rsn.user.accounts.repository.UserRepository;
import com.rsn.user.accounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long createUser(UserParamsDto userParamsDto) {
        if (userRepository.existsByName(userParamsDto.getName())) {
            return -1L;
        }

        User user = new User();
        user.setId(userParamsDto.getId());
        user.setName(userParamsDto.getName());
        user.setPassword(passwordEncoder.encode(userParamsDto.getPassword()));
        user.setDateOfBirth(userParamsDto.getDateOfBirth());
        user.setAccount(new Account());
        user.getAccount().setBalance(userParamsDto.getBalance());

        user.setEmailData(new HashSet<EmailData>());
        EmailData email = new EmailData();
        email.setEmail(userParamsDto.getEmail());
        user.getEmailData().add(email);

        Set<PhoneData> phoneData = new HashSet<PhoneData>();
        PhoneData phone = new PhoneData();
        phone.setPhone(userParamsDto.getPhone());
        phoneData.add(phone);
        user.setPhoneData(phoneData);

        userRepository.save(user);
        return user.getId();
    }

    @Override
    public List<UserResponse> findUsersByParams(SearchParamsDto params) {
        return List.of();
    }

    @Override
    public UserResponseWithCredentials getUserCredentialsByUsername(String username) {
        User user = userRepository.findByName(username);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setAccount(new AccountDto());
        userResponse.getAccount().setBalance(user.getAccount().getBalance());
        return new UserResponseWithCredentials(
                userResponse, user.getPassword());
    }


}
