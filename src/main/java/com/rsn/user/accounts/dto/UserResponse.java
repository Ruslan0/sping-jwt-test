package com.rsn.user.accounts.dto;

import com.rsn.user.accounts.common.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserResponse {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private AccountDto account;
    private List<EmailDataDto> emailData;
    private List<PhoneDataDto> phoneData;
    List<Role> roles;
    Boolean active;
}
