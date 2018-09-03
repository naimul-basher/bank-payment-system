package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Web.BankPayment.dto.DMS_PO_DTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.DMSPOManualRealizeServiceInterface;
import com.Web.BankPayment.serviceInterfaces.DMS_PO_ServiceInterface;

@RestController
public class DMS_PO_Controller {
	
	private final DMS_PO_ServiceInterface DMS_PO_interface;
	private final DMSPOManualRealizeServiceInterface DMSPOManualRealizeInterface;

	@Autowired
	public DMS_PO_Controller(final DMS_PO_ServiceInterface dMS_PO_interface, 
			final DMSPOManualRealizeServiceInterface DMSPOManualRealizeInterface) {
	
		this.DMS_PO_interface = dMS_PO_interface;
		this.DMSPOManualRealizeInterface = DMSPOManualRealizeInterface;
	}
	
	@PostMapping("/api/v1/dms-purchase-order/add")
	public ResponseEntity<Response> saveDMS_PO(@RequestBody @Validated DMS_PO_DTO dto, 
			BindingResult bindingResult, HttpServletResponse servletResponse) {
		
		System.out.println(dto);
		
		return DMS_PO_interface.saveDMS_PO(dto, bindingResult, servletResponse);
	}
	
	@PostMapping("/api/v1/dms-purchase-order/realize")
	public ResponseEntity<Response> realizeDMS_PO(@RequestBody @Validated DMS_PO_DTO dto, 
			BindingResult bindingResult, HttpServletResponse servletResponse) {
		
		return DMSPOManualRealizeInterface.realizePendingPO(dto, bindingResult, servletResponse);
		//return null;
	}
	
	@GetMapping("/api/v1/dms-purchase-order/pending")
	public ResponseEntity<Response> getPendingPO(HttpServletRequest ServletRequest, HttpServletResponse servletResponse) {
				
		return DMS_PO_interface.viewAllPendingPO(servletResponse);
	}

}
