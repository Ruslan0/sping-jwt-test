package com.rsn.user.accounts.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SearchParamsDto {
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    @Email
    private String email;
    @Pattern(regexp="(^$|[0-9]{13})")
    private String phone;

    private Integer page;
    private Integer size;
    private Integer offset;
}
