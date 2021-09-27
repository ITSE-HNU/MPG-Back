package com.ghstudio.pairprogram.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TokenConfig token 配置：有效时间  密匙
 */
@Data
@Component
@ConfigurationProperties(prefix = "token")
public class TokenConfig {
    private long expireDate;
    private String secret;
}
