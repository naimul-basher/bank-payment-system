package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.ViewServiceInterface;

@RestController
public class ViewController {
	
	private final ViewServiceInterface viewInterface;
	
	@Autowired
	public ViewController (final ViewServiceInterface viewInterface) {
		this.viewInterface = viewInterface;
	}
	
	@GetMapping("/api/v1/users/{id}")
	public ResponseEntity<Response> viewById(@PathVariable Integer id, 
			HttpServletRequest ServletRequest, HttpServletResponse servletResponse) {
		
		System.out.println(id);
				
		return viewInterface.viewById(id, ServletRequest, servletResponse);
	}
	
	@GetMapping("/api/v1/users")
	public ResponseEntity<Response> viewAll(HttpServletRequest ServletRequest, HttpServletResponse servletResponse) {
		
		System.out.println("View All");
				
		return viewInterface.viewAll(ServletRequest, servletResponse);
	}
	
}
