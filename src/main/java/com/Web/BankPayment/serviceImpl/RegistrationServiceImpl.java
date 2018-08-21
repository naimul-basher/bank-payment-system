package com.Web.BankPayment.serviceImpl;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.RegistrationDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.models.User;
import com.Web.BankPayment.repository.UserRepository;
import com.Web.BankPayment.serviceInterfaces.RegistrationServiceInterface;


@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationServiceInterface {

	private final UserRepository userRepo;
	private final ModelMapper modelMapper;

	@Autowired
	public RegistrationServiceImpl (final UserRepository userRepo, final ModelMapper modelMapper) {
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<Response> save(RegistrationDTO dto, BindingResult bindingResult,
			HttpServletResponse servletResponse) {
		
		Response response = new Response();
		
		if(bindingResult.hasErrors()) {
			response.setStatus("Bad Request");
			response.setStatusCode(400);
			response.setMessage("Initial Validation Failed");
			response.setContent(bindingResult.getAllErrors());
			
			return new ResponseEntity<Response> (response, HttpStatus.BAD_REQUEST);
		}
		else {

			if (userRepo.findByusername(dto.getUsername()) != null) {
				response.setStatus("Already Exists");
				response.setStatusCode(409);
				response.setMessage("User Already Exists");
				response.setContent(null);
				
				return new ResponseEntity<Response> (response, HttpStatus.CONFLICT);
			}
			else {
				User user = new User();
				modelMapper.map(dto,  user);
				userRepo.save(user);

				response.setStatus("Created");
				response.setStatusCode(201);
				response.setMessage("New User Created");
				response.setContent(user);
				
				return new ResponseEntity<Response> (response, HttpStatus.CREATED);				
			}
			
		}

	}

}
