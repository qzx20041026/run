package com.qzx.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

public class JwtUtils {
    private static final String SECRET_KEY = "cXp4";// 密钥
    private static final long EXPIRATION_TIME = 12*60*60*1000;// 过期时间

    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256,SECRET_KEY)// 使用HS256算法和密钥生成JWT令牌
                .addClaims(claims)
                .setExpiration(new java.util.Date(System.currentTimeMillis() + EXPIRATION_TIME))// 设置过期时间
                .compact();
    }
    public static Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
