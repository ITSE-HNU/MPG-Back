package com.ghstudio.pairprogram.service.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.List;

@Data
@Builder
public class PaperResponseBody {
    private int count;
    private List<Title> titles;

    @Tolerate
    public PaperResponseBody() {
    }

    @Data
    @Builder
    public static class Title {
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
