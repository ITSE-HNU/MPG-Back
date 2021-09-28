package com.ghstudio.pairprogram.dao.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;

@Data
@Builder
public class Verify {
    private int id;
    private String phone;
    private String code;
    private Date createdAt;

    @Tolerate
    public Verify() {
    }
}
