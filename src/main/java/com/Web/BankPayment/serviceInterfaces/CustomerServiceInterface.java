package com.Web.BankPayment.serviceInterfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.BankPaymentDTO;
import com.Web.BankPayment.dto.CustomerDTO;
import com.Web.BankPayment.dto.Response;

public interface CustomerServiceInterface {
	
	public ResponseEntity<Response> saveCustomerList(CustomerDTO dto, BindingResult bindingResult, 
			HttpServletRequest servletRequest, HttpServletResponse servletResponse);

}
