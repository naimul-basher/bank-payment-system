package com.Web.BankPayment.serviceImpl;


import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.DMS_PO_DTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.models.DMS_PO;
import com.Web.BankPayment.models.Wallet;
import com.Web.BankPayment.repository.CustomerRepository;
import com.Web.BankPayment.repository.DMS_PORepository;
import com.Web.BankPayment.repository.WalletRepository;
import com.Web.BankPayment.serviceInterfaces.DMSPOManualRealizeServiceInterface;

@Service
@Transactional
public class DMSPOManualRealizeServiceImpl implements DMSPOManualRealizeServiceInterface {
	
	private final DMS_PORepository dmsPORepo;
	private final WalletRepository walletRepo;
	private final CustomerRepository customerRepo;
		
	@Autowired
	public DMSPOManualRealizeServiceImpl(final DMS_PORepository dmsPORepo, final WalletRepository walletRepo,
			final CustomerRepository customerRepo) {
		this.dmsPORepo = dmsPORepo;
		this.walletRepo = walletRepo;
		this.customerRepo = customerRepo;
	}


	@Override
	public ResponseEntity<Response> realizePendingPO(DMS_PO_DTO dto, BindingResult bindingResult,
			HttpServletResponse servletResponse) {
		
		DMS_PO purchaseOrder = new DMS_PO();

		Response response = new Response();
		
		if(bindingResult.hasErrors()) {
			response.setStatus("Bad Request");
			response.setStatusCode(400);
			response.setMessage("Initial Validation Failed");
			response.setContent(bindingResult.getAllErrors());
			
			return new ResponseEntity<Response> (response, HttpStatus.BAD_REQUEST);
		}
		else {
			
			purchaseOrder = dmsPORepo.findBypurchaseOrderNumber(dto.getPurchaseOrderNumber());

			if (purchaseOrder == null || purchaseOrder.getClearPO() == true) {
	
				response.setStatus("Not Found");
				response.setStatusCode(404);
				response.setMessage("No Pending PO Found for Realization");
				response.setContent(null);
				
				return new ResponseEntity<Response> (response, HttpStatus.NOT_FOUND);
			}
			else {
				
				Wallet wallet = walletRepo.findBycustomerWalletID(
						customerRepo.findBycustomerPOSCode(purchaseOrder.getCustomerPOSCode())
						.getCustomerWalletID());
				
				wallet.setBalance(wallet.getBalance() - purchaseOrder.getAmount() );
				wallet.setLastUpdateDateTime(LocalDateTime.now());
				purchaseOrder.setClearPO(true);
				purchaseOrder.setClearDateTime(LocalDateTime.now());
				System.out.println("Wallet Balance: " + wallet);
				//	Invoke DMS API for PO Realization Posting
				dmsPORepo.save(purchaseOrder);
				walletRepo.save(wallet);
								
				response.setStatus("Created");
				response.setStatusCode(202);
				response.setMessage("Pending Purchase Order Realized");
				response.setContent(purchaseOrder);
			
				return new ResponseEntity<Response> (response, HttpStatus.ACCEPTED);				
			}
		}
		
	}
}

		

