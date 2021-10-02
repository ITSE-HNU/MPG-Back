package com.ghstudio.pairprogram.dao.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * Title 试题定义
 */
@Data
@Builder
public class Title {
    private int id;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correct;

    @Tolerate
    public Title() {
    }
}
