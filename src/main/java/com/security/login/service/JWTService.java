//package com.security.login.service;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
////@Service
////public class JWTService {
////
////    private String secretKey = "";
////
////    public JWTService(){
////        try{
////            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
////            SecretKey sk= keyGen.generateKey();
////            secretKey= Base64.getEncoder().encodeToString(sk.getEncoded());
////        } catch (NoSuchAlgorithmException e) {
////            throw new RuntimeException(e);
////        }
////    }
////    public String generateToken(String username) {
////
////        Map<String, Object> claims= new HashMap<>();
////        return Jwts.builder()
////                .claims()
////                .add(claims)
////                .subject(username)
////                .issuedAt(new Date(System.currentTimeMillis()))
////                .expiration(new Date(System.currentTimeMillis()+60*60*10))
////                .and()
////                .signWith(getKey())
////                .compact();
////
////
////    }
////
////    private Key getKey() {
////        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
////        return Keys.hmacShaKeyFor(keyBytes);
////    }
////}
//@Service
//public class JWTService {
//    // This is a sample secret key - in production, use a secure key and store it safely
//    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
//
//    public String generateToken(String username) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, username);
//    }
//
//    private String createToken(Map<String, Object> claims, String username) {
//        return Jwts.builder()
//                .claims(claims)
//                .subject(username)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours token validity
//                .signWith(getSigningKey())
//                .compact();
//    }
//
//    private SecretKey getSigningKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parser()
//                .verifyWith(getSigningKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload()
//                .getSubject();
//    }
//
//    public boolean isTokenValid(String token) {
//        try {
//            Jwts.parser()
//                    .verifyWith(getSigningKey())
//                    .build()
//                    .parseSignedClaims(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
package com.security.login.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {
    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    private final SecretKey key;

    public JWTService() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key)
                .compact();
    }
}
