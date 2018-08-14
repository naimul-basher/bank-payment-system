package com.Web.BankPayment.serviceInterfaces;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.RegistrationDTO;
import com.Web.BankPayment.dto.Response;


public interface RegistrationServiceInterface {
	
	public ResponseEntity<Response> save(RegistrationDTO dto, BindingResult bindingResult, 	HttpServletResponse servletResponse);

}
