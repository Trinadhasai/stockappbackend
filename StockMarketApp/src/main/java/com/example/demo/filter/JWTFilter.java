package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


public class JWTFilter extends GenericFilter 
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	HttpServletRequest httpRequest=(HttpServletRequest) request;
	HttpServletResponse httpResponse=(HttpServletResponse) response;
	
	String authHeader=httpRequest.getHeader("authorization");
	
	if(authHeader==null || !authHeader.startsWith("Bearer"))
	{
		throw new ServletException("Missing or invalid authorization header");
		
	}
	
	String JWTToken =authHeader.substring(7);
	System.out.println(authHeader);
	
	Claims claim=Jwts.parser().setSigningKey("secret key").parseClaimsJws(JWTToken).getBody();
	
	httpRequest.setAttribute("username", claim);
	
	chain.doFilter(request,response);
		
	}
	

}
