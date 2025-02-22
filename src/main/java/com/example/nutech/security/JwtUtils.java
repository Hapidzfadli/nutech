package com.example.nutech.security;

import com.example.nutech.entity.User;
import com.example.nutech.utils.constant.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    private SecretKey getSignKey(){
        return Keys.hmacShaKeyFor(Constants.JWT_SIGNATURE_SECRET.getBytes());
    }

    public String generateAccessToken(User user){
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + Constants.JWT_EXPIRATION);
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(currentDate)
                .expiration(expirationDate)
                .signWith(getSignKey())
                .compact();
    }

    public String extractEmail(String token) {
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e){
            return null;
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
