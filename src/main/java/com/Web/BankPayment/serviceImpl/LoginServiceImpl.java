package com.Web.BankPayment.serviceImpl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.LoginDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.models.User;
import com.Web.BankPayment.repository.UserRepository;
import com.Web.BankPayment.serviceInterfaces.LoginServiceInterface;
import com.Web.BankPayment.util.Token;

@Service
@Transactional
public class LoginServiceImpl implements LoginServiceInterface{
	
	private final UserRepository userRepo;
	
	@Autowired
	public LoginServiceImpl (final UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public ResponseEntity<Response> verify (LoginDTO dto, BindingResult bindingResult, 	HttpServletResponse servletResponse) {
		
		Response response = new Response();
		
		if(bindingResult.hasErrors()) {
			response.setStatus("Bad Request");
			response.setStatusCode(400);
			response.setMessage("Initial Validation Failed");
			response.setContent(bindingResult.getAllErrors());
			
			return new ResponseEntity<Response> (response, HttpStatus.BAD_REQUEST);
		}
		else {
			User user = new User();
			// modelMapper.map(dto,  user);
			
			user = userRepo.findByusername(dto.getUsername());
			
			if(user.getPassword().matches(dto.getPassword())) {
				
				String jwtToken = new Token().createToken(user.getUsername(), "id", String.valueOf(user.getId()));
								
				response.setStatus("Success");
				response.setStatusCode(200);
				response.setMessage("Login Successful");
				response.setContent(jwtToken);
				
				return new ResponseEntity<Response> (response, HttpStatus.ACCEPTED);
			}
			
			else {
				response.setStatus("Failed");
				response.setStatusCode(401);
				response.setMessage("Login Denied");
				response.setContent(null);
				
				return new ResponseEntity<Response> (response, HttpStatus.UNAUTHORIZED);				
			}
			
		}
		
	}

}
