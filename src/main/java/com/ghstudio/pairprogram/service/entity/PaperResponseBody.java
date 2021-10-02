package com.ghstudio.pairprogram.service.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.List;

/**
 * PaperResponseBody 试卷请求返回体
 */
@Data
@Builder
public class PaperResponseBody {
    private int count;
    private List<Title> titles;

    @Tolerate
    public PaperResponseBody() {
    }

    /**
     * Title 试题请求返回体
     */
    @Data
    @Builder
    public static class Title {
        private int id;
        private String question;
        private String choiceA;
        private String choiceB;
        private String choiceC;
        private String choiceD;
        private String answer;

        @Tolerate
        public Title() {
        }
    }
}
