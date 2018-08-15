package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Web.BankPayment.dto.CustomerDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.CustomerServiceInterface;

@RestController
public class CustomerController {
	
	private final CustomerServiceInterface customerInterface;
	
	@Autowired
	public CustomerController (final CustomerServiceInterface customerInterface) {
		this.customerInterface = customerInterface;
	}
	
	@PostMapping("/api/v1/customer/add")
	public ResponseEntity<Response> saveCustomerList(@RequestBody @Validated CustomerDTO dto, 
			BindingResult bindingResult, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		System.out.println(dto);
		
		return customerInterface.saveCustomerList(dto, bindingResult, servletRequest, servletResponse);
	}
	
}
