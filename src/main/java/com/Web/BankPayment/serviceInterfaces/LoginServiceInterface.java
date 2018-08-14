package com.Web.BankPayment.serviceInterfaces;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.LoginDTO;
import com.Web.BankPayment.dto.Response;

public interface LoginServiceInterface {

	public ResponseEntity<Response> verify(LoginDTO dto, BindingResult bindingResult, 	HttpServletResponse servletResponse);
	
}
