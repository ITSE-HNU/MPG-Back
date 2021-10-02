package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VerifyCodeRequestBody {
    @NotEmpty
    private String phoneNumber;
}
