package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Web.BankPayment.dto.DMS_PO_DTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.DMS_PO_ServiceInterface;

@RestController
public class DMS_PO_Controller {
	
	private final DMS_PO_ServiceInterface DMS_PO_interface;

	@Autowired
	public DMS_PO_Controller(final DMS_PO_ServiceInterface dMS_PO_interface) {
	
		this.DMS_PO_interface = dMS_PO_interface;
	}
	
	@PostMapping("/api/v1/dms-purchase-order/add")
	public ResponseEntity<Response> saveDMS_PO(@RequestBody @Validated DMS_PO_DTO dto, 
			BindingResult bindingResult, HttpServletResponse servletResponse) {
		
		System.out.println(dto);
		
		return DMS_PO_interface.saveDMS_PO(dto, bindingResult, servletResponse);
	}
}
