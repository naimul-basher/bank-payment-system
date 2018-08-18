package com.Web.BankPayment.serviceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.CustomerDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.CustomerServiceInterface;

import io.jsonwebtoken.Claims;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServiceInterface {

	@Override
	public ResponseEntity<Response> saveCustomerList(CustomerDTO dto, BindingResult bindingResult,
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		Response response = new Response();
		Claims claims = (Claims)servletRequest.getAttribute("claims");
		
		if(claims != null) {
			
			response.setStatus("Created");
			response.setStatusCode(201);
			response.setMessage("New Transaction Created");
			response.setContent(null);
			
			return new ResponseEntity<Response> (response, HttpStatus.CREATED);
		}
		else {
			response.setStatus("Unauthorized");
			response.setStatusCode(401);
			response.setMessage("Unauthorized Access");
			response.setContent(null);
			
			return new ResponseEntity<Response> (response, HttpStatus.UNAUTHORIZED);
		}
		
	}
	

}
