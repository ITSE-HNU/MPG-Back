package com.ghstudio.pairprogram.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * HazelnutCloudConfig 榛子云配置文件参数：请求url appId appSecret 模板ID
 */
@Data
@Component
@ConfigurationProperties(prefix = "hazelnut")
public class HazelnutCloudConfig {
    private String url;
    private String appId;
    private String appSecret;
    private String templateId;
}
