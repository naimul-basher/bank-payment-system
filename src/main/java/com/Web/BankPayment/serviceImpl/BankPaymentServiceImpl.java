package com.Web.BankPayment.serviceImpl;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.BankPaymentDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.models.BankTransaction;
import com.Web.BankPayment.repository.BankPaymentRepository;
import com.Web.BankPayment.serviceInterfaces.BankPaymentServiceInterface;


@Service
@Transactional
public class BankPaymentServiceImpl implements BankPaymentServiceInterface {

	private final BankPaymentRepository bankPaymentRepo;
	private final ModelMapper modelMapper;

	@Autowired
	public BankPaymentServiceImpl (final BankPaymentRepository bankPaymentRepo, final ModelMapper modelMapper) {
		this.bankPaymentRepo = bankPaymentRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<Response> saveBankTransaction(BankPaymentDTO dto, BindingResult bindingResult,
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

			if (bankPaymentRepo.findBybankTransactionID(dto.getBankTransactionID()) != null) {
				response.setStatus("Duplicate");
				response.setStatusCode(409);
				response.setMessage("Transaction Duplicate");
				response.setContent(null);
				
				return new ResponseEntity<Response> (response, HttpStatus.CONFLICT);
			}
			else {
				BankTransaction transaction = new BankTransaction();
				modelMapper.map(dto,  transaction);
				bankPaymentRepo.save(transaction);

				response.setStatus("Created");
				response.setStatusCode(201);
				response.setMessage("New Transaction Created");
				response.setContent(null);
				
				return new ResponseEntity<Response> (response, HttpStatus.CREATED);				
			}
			
		}

	}

}
