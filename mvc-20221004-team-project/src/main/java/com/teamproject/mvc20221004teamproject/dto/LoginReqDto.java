package com.teamproject.mvc20221004teamproject.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@Data
public class LoginReqDto {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}
