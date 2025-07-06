package com.rsn.user.accounts.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDataDto {
    private Long id;
    @Pattern(regexp="(^$|[0-9]{13})")
    private String phone;
}
