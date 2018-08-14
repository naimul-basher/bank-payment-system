package com.Web.BankPayment.serviceInterfaces;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.BankPaymentDTO;
import com.Web.BankPayment.dto.Response;

public interface BankPaymentServiceInterface {

	public ResponseEntity<Response> saveBankTransaction(BankPaymentDTO dto, BindingResult bindingResult, 
			HttpServletResponse servletResponse);

}
