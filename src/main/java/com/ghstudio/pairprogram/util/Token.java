package com.ghstudio.pairprogram.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ghstudio.pairprogram.config.TokenConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Token token 操作封装工具
 */
@Component
public class Token {
    @Resource
    private TokenConfig tokenConfig;

    /**
     * sign 登陆时发布 token
     *
     * @param id 用户 id
     * @return String token 字符串
     */
    public String sign(int id) {
        //过期时间
        Date date = new Date(System.currentTimeMillis() + tokenConfig.getExpireDate());
        //秘钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(tokenConfig.getSecret());
        //设置 header 信息
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        //携带username，password信息，生成签名
        return JWT.create()
                .withHeader(header)
                .withClaim("id", id)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * verify 解析 token
     *
     * @param token 传入的 token
     * @return Integer 用户的 id
     */
    public Integer verify(String token) {
        Algorithm algorithm = Algorithm.HMAC256(tokenConfig.getSecret());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        Claim claim = jwt.getClaim("id");
        return claim.asInt();
    }
}
