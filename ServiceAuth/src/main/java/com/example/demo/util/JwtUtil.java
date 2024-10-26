package com.example.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Token;
@Component
@Slf4j

public class JwtUtil {
    private String secretKey = "doantotnghiepcualongvanghia";

    public String generateToken(Token token) {
    	token.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10).toString());
    	
        return Jwts.builder()
                .setSubject(token.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
	public String authenticate(String token) {
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		System.out.println(claims.getSubject());
		return claims.getSubject();
	}
    public boolean validateToken(String token, String username) {
        return username.equals(extractClaims(token).getSubject()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
