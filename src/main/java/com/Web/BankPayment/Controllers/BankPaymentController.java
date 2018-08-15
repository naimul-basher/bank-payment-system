package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Web.BankPayment.dto.BankPaymentDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.BankPaymentServiceInterface;


@RestController
public class BankPaymentController {
	
	private final BankPaymentServiceInterface bankPaymentInterface;
	
	@Autowired
	public BankPaymentController (final BankPaymentServiceInterface bankPaymentInterface) {
		this.bankPaymentInterface = bankPaymentInterface;
	}
	
	@PostMapping("/api/v1/bank-transaction/add")
	public ResponseEntity<Response> saveBankTransactions(@RequestBody @Validated BankPaymentDTO dto, 
			BindingResult bindingResult, HttpServletResponse servletResponse) {
		
		System.out.println(dto);
		
		return bankPaymentInterface.saveBankTransaction(dto, bindingResult, servletResponse);
	}
}
