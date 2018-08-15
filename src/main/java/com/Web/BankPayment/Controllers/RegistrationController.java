package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Web.BankPayment.dto.RegistrationDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.RegistrationServiceInterface;


@RestController
public class RegistrationController {
	
	private final RegistrationServiceInterface regInterface;
	
	@Autowired
	public RegistrationController (final RegistrationServiceInterface regInterface) {
		this.regInterface = regInterface;
	}
	
	@PostMapping("/api/v1/users/add")
	public ResponseEntity<Response> saveUsers(@RequestBody @Validated RegistrationDTO dto, 
			BindingResult bindingResult, HttpServletResponse servletResponse) {
		
		System.out.println(dto);
		
		return regInterface.save(dto, bindingResult, servletResponse);
	}
}
