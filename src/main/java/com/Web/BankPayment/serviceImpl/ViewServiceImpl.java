package com.Web.BankPayment.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.models.User;
import com.Web.BankPayment.repository.UserRepository;
import com.Web.BankPayment.serviceInterfaces.ViewServiceInterface;

import io.jsonwebtoken.Claims;

@Service
@Transactional
public class ViewServiceImpl implements ViewServiceInterface {
	
	private final UserRepository userRepo;
	private Response response;
	
	@Autowired
	public ViewServiceImpl (final UserRepository userRepo, final Response response) {
		this.userRepo = userRepo;
		this.response = response;
	}

	@Override
	public ResponseEntity<Response> viewAll(HttpServletRequest servletRequest, 
			HttpServletResponse servletResponse) {
		
		Claims claims = (Claims)servletRequest.getAttribute("claims");
		
		if(claims != null) {
		
			List<User> users = new ArrayList<>();
		    userRepo.findAll().forEach(users::add); //fun with Java 8
		
		    response.setStatus("Success");
			response.setStatusCode(302);
			response.setMessage("User Found");
			response.setContent(users);
		    		
		    return new ResponseEntity<Response> (response, HttpStatus.FOUND);
		}
		else {
			response.setStatus("Unauthorized");
			response.setStatusCode(401);
			response.setMessage("Unauthorized Access");
			response.setContent(null);
			
			return new ResponseEntity<Response> (response, HttpStatus.UNAUTHORIZED);			
		}
	}

	public ResponseEntity<Response> viewById(Integer id, 
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		Claims claims = (Claims)servletRequest.getAttribute("claims");
		
		if(claims != null) {
			@SuppressWarnings("unused")
			String userId = (String) claims.get("id");
			
			User user = new User();
			user = userRepo.findByid(id);
			
			if (user != null) {
				response.setStatus("Success");
				response.setStatusCode(302);
				response.setMessage("User Found");
				response.setContent(user);
				
				return new ResponseEntity<Response> (response, HttpStatus.FOUND);
			}
			else {
				response.setStatus("Bad Request");
				response.setStatusCode(404);
				response.setMessage("User Not Found");
				response.setContent(null);
				
				return new ResponseEntity<Response> (response, HttpStatus.NOT_FOUND);
			}
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
