package com.example.spring_phoneshop.security;

import com.example.spring_phoneshop.utils.Constants;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JWTProvider {

    public String generateToken(String username) {
        Date currentDate = new Date();
        Date expireAcessTokenDate = new Date(currentDate.getTime() + Constants.ACCESS_TOKEN_EXPIRATION);
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireAcessTokenDate)
                .signWith(SignatureAlgorithm.HS512, Constants.JWT_SECRET)
                .compact();
        return token;
    }

    public String generateRefreshToken(String userId) {
        Date currentDate = new Date();
        Date expireRefreshTokenDate = new Date(currentDate.getTime() + Constants.REFRESH_TOKEN_EXPIRATION);
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(expireRefreshTokenDate)
                .signWith(SignatureAlgorithm.HS512, Constants.JWT_SECRET)
                .compact();
    }
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Constants.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(Constants.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error(ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.error(ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.error(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error(ex.getMessage());
        }
        return false;
    }

    public static boolean validateRefreshToken(String refreshToken) {
        try {
            Jwts.parser()
                    .setSigningKey(Constants.JWT_SECRET)
                    .parseClaimsJws(refreshToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
