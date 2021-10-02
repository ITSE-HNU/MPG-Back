package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PaperRequestBody {
    @NotEmpty
    private Integer role;
    @NotEmpty
    private Integer count;
}
