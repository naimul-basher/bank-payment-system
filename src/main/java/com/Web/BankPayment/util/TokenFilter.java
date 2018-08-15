package com.Web.BankPayment.util;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;

import org.springframework.core.annotation.Order;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Order(1)
public class TokenFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
	        throws IOException, ServletException {

	    final HttpServletRequest request = (HttpServletRequest) req;
	    final HttpServletResponse response = (HttpServletResponse) res;
	    final String authHeader = request.getHeader("authorization");

	    if ("OPTIONS".equals(request.getMethod())) {
	        response.setStatus(HttpServletResponse.SC_OK);

	        chain.doFilter(req, res);
	    } 
	    else {

	        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	            throw new ServletException("Missing or invalid Authorization header");
	        }

	        final String token = authHeader.substring(7);

            try {
            	final Claims claims = Jwts.parser().setSigningKey(Token.SECRET_KEY).parseClaimsJws(token).getBody();
            	request.setAttribute("claims", claims);
            }
            catch (SignatureException e) {
                throw new ServletException("Invalid Token");
            }
	        chain.doFilter(req, res);
	    }
	}

}
