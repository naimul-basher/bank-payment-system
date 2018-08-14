package com.Web.BankPayment.util;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Token {
	
	public static final String SECRET_KEY = "bangbang";
	
	public String createToken(String tokenSubject, String tokenKey, String tokenValue) {
		
		return Jwts.builder().setSubject(tokenSubject)
				.claim(tokenKey, tokenValue).setIssuedAt(new Date())
	            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

}
