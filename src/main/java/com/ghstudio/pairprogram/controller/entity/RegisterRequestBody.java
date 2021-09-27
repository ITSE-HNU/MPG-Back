package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterRequestBody {
    @NotEmpty
    private String phoneNumber;
}
