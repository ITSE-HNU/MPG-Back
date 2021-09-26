package com.ghstudio.pairprogram.util.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageSendResponse {
    @JsonProperty("code")
    private String code;
    @JsonProperty("data")
    private String data;
}
