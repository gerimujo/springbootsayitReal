package com.SayItApp.SayItOrganization.util;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil implements Serializable {

    private static final String SECRET_KEY = "ggygfiodfewfwefvgewcddsdewc"; // Replace with your actual secret key

    
    public String generateToken(UserDetails userDetails){
Map<String, Object> claims = new HashMap<>();
return doGenerateToken(claims,userDetails.getUsername());

    }
private String doGenerateToken(Map<String, Object> claims, String subject){
    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
    .setExpiration(new  Date(Long.MAX_VALUE))
    .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
}

    public Date getExpirationDateFromToken(String token){
return getClaimFromToken(token, Claims::getIssuedAt);
    }
private Boolean isTokenExpired(String token){
    final Date expiration = getExpirationDateFromToken(token);
    return !expiration.before(new Date());
}

public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
final Claims claims = getAllClaimsFromToken(token);
return claimsResolver.apply(claims);
}
    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            final String username = getUsernameFromToken(token);
           
return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));
        } catch (Exception e) {
           
            return false;
        }
    }
    public String getUsernameFromToken(String token) {
    

       return getClaimFromToken(token, Claims::getSubject);
    }
}
