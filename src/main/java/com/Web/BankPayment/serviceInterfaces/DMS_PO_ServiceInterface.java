package com.Web.BankPayment.serviceInterfaces;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.DMS_PO_DTO;
import com.Web.BankPayment.dto.Response;

public interface DMS_PO_ServiceInterface {
	
	public ResponseEntity<Response> saveDMS_PO(DMS_PO_DTO dto, BindingResult bindingResult, 
			HttpServletResponse servletResponse);

	public ResponseEntity<Response> viewAllPendingPO(HttpServletResponse servletResponse);
}
