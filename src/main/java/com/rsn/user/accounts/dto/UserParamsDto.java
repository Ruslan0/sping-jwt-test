package com.rsn.user.accounts.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rsn.user.accounts.common.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserParamsDto {
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    @Size(min = 8, max = 500, message = "Password must be at least 8 characters long and less then equal to 500")
    private String password;
    @Min(0)
    private BigDecimal balance;
    @Email
    private String email;
    @Pattern(regexp = "(^$|[0-9]{13})")
    private String phone;
}
