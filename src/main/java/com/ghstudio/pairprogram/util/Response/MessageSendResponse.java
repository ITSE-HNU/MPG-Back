package com.ghstudio.pairprogram.util.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * MessageSendResponse 短信发送请求返回体 用于校验短信是否发送成功
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageSendResponse {
    @JsonProperty("code")
    private String code;
    @JsonProperty("data")
    private String data;
}
