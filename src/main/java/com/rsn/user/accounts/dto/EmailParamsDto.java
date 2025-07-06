package com.rsn.user.accounts.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailParamsDto {
    private Long id;
    private Long userId;
    @Email
    private String email;
}
