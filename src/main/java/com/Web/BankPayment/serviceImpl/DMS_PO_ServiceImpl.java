package com.Web.BankPayment.serviceImpl;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.DMS_PO_DTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.models.DMS_PO;
import com.Web.BankPayment.repository.DMS_PORepository;
import com.Web.BankPayment.serviceInterfaces.DMS_PO_ServiceInterface;

@Service
@Transactional
public class DMS_PO_ServiceImpl implements DMS_PO_ServiceInterface {

	private final DMS_PORepository DMS_PO_repo;
	private final ModelMapper modelMapper;
	private DMS_PO DMS_purchase_order;
	
	@Autowired
	public DMS_PO_ServiceImpl(final DMS_PORepository dMS_PO_repo, final ModelMapper modelMapper) {
		this.DMS_PO_repo = dMS_PO_repo;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ResponseEntity<Response> saveDMS_PO(DMS_PO_DTO dto, BindingResult bindingResult,
			HttpServletResponse servletResponse) {
	
		Response response = new Response();
		
		if(bindingResult.hasErrors()) {
			response.setStatus("Bad Request");
			response.setStatusCode(400);
			response.setMessage("Initial Validation Failed");
			response.setContent(bindingResult.getAllErrors());
			
			return new ResponseEntity<Response> (response, HttpStatus.BAD_REQUEST);
		}
		else if ( (DMS_purchase_order = DMS_PO_repo.findBypurchaseOrderNumber(dto.getPurchaseOrderNumber())) != null) {

			System.out.println(DMS_purchase_order);
			response.setStatus("Duplicate");
			response.setStatusCode(409);
			response.setMessage("Transaction Duplicate");
			response.setContent(null);
			
			return new ResponseEntity<Response> (response, HttpStatus.CONFLICT);
		}
		else {
			
			DMS_purchase_order = new DMS_PO();
			modelMapper.map(dto, DMS_purchase_order);
			DMS_purchase_order.setClearDateTime(null);
			DMS_purchase_order.setClearPO(false);
			DMS_PO_repo.save(DMS_purchase_order);
			
			response.setStatus("Created");
			response.setStatusCode(201);
			response.setMessage("New Purchase Order Created");
			response.setContent(DMS_purchase_order);
			
			return new ResponseEntity<Response> (response, HttpStatus.CREATED);				
		}
	}
	
}
