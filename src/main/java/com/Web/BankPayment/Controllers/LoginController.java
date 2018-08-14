package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Web.BankPayment.dto.LoginDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.LoginServiceInterface;


@RestController
public class LoginController {
	
	private final LoginServiceInterface loginInterface;
	
	@Autowired
	public LoginController (final LoginServiceInterface loginInterface) {
		this.loginInterface = loginInterface;
	}
	
	@PostMapping("/api/v1/login")
	public ResponseEntity<Response> login(@RequestBody @Validated LoginDTO dto, 
			BindingResult bindingResult, HttpServletResponse servletResponse) {
		
		System.out.println(dto);
		
		return loginInterface.verify(dto, bindingResult, servletResponse);
	}

}