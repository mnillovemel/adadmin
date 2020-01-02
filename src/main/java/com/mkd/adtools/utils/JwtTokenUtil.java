package com.mkd.adtools.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 *
 */

@Component
public class JwtTokenUtil implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 5372900910708033790L;
	/**
     * 密钥
     */
    private final static String secret = "kedouwo007";

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     * 2592000L * 1000 =30天
     * 
     */
    private static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + 2592000L * 1000);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 
     * @return 数据声明
     */
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     * @return 令牌
     */
    public static String generateToken(String username,String userId) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("username", username);
        claims.put("userId", userId);
        claims.put("created", new Date());
        return generateToken(claims);
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public static void main(String[] args){
//    	String s = generateToken("151","111");
//    	System.out.println("s:"+s);
    	Claims a = getClaimsFromToken("eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NjI4MzM0NzEsInBob25lIjoidGVzdCIsInVzZXJJZCI6IjEiLCJjcmVhdGVkIjoxNTYwMjQxNDcxNjcyfQ.U5BnbM2nWeDkxVtVfbIS3OT1xIsjJ37zTG0MbHdlYzb3KK-Qpll_aS-udN6A1imHsF2NLackMIF2aNxq9_I9ig") ;
    	System.out.println(":"+a.get("phone")+":userID:"+a.get("userId") +" :"+a.get("created"));


    }
}