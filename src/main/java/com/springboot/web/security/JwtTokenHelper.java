package com.springboot.web.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenHelper {

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	private String secret = "jwtTokenKey";

//	Retrieve user name from jwt token

	public String getUsernameFromToken(String token) {
		return 
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsRe)
	
	public Boolen 
}
