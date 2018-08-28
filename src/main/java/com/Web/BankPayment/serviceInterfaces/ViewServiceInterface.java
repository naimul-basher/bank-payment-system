package com.Web.BankPayment.serviceInterfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.Web.BankPayment.dto.Response;

public interface ViewServiceInterface {
	
	public ResponseEntity<Response> viewAll(HttpServletRequest ServletRequest, 
			HttpServletResponse servletResponse);
	
	public ResponseEntity<Response> viewById(Integer id, 
			HttpServletRequest ServletRequest, HttpServletResponse servletResponse);
}
