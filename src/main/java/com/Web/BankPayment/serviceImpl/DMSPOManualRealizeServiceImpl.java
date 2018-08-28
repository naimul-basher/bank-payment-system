package com.Web.BankPayment.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.DMS_PO_DTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.models.DMS_PO;
import com.Web.BankPayment.models.Wallet;
import com.Web.BankPayment.repository.DMS_PORepository;
import com.Web.BankPayment.repository.WalletRepository;
import com.Web.BankPayment.serviceInterfaces.DMSPOManualRealizeServiceInterface;

public class DMSPOManualRealizeServiceImpl implements DMSPOManualRealizeServiceInterface {
	
	@Autowired
	private DMS_PORepository dmsPORepo;
	
	@Autowired
	private WalletRepository walletRepo;
	
	List<DMS_PO> pendingPOList = new ArrayList<DMS_PO>();

	@Override
	public ResponseEntity<Response> viewAllPendingPO(BindingResult bindingResult, HttpServletResponse servletResponse) {
		
		pendingPOList = dmsPORepo.findByclearPO(false);
		
		
		
		/*
		
		if(!pendingPOList.isEmpty()) {
			pendingPOList.sort(Comparator.comparing(DMS_PO::getPurchaseOrderType)
					.reversed()
					.thenComparing(Comparator.comparing(DMS_PO::getIssueDateTime)
							//.reversed()
							)
					);
			
			System.out.println("The time is now: " + LocalDateTime.now());
			pendingPOList.forEach(System.out::println);
			
			pendingPOList.forEach( PO -> {
				
				Wallet wallet = walletRepo.findBycustomerWalletID(
								customerRepo.findBycustomerPOSCode(PO.getCustomerPOSCode())
								.getCustomerWalletID());
				
				System.out.println("[" + PO.getCustomerPOSCode() + ":" + wallet.getCustomerWalletID() + "] "  
						+ "Wallet-Balance [" + wallet.getBalance() + "] PO-Amount [" + PO.getAmount() + "]");
				
				
				if(wallet.getBalance() >= PO.getAmount()) {
					wallet.setBalance(wallet.getBalance() - PO.getAmount() );
					wallet.setLastUpdateDateTime(LocalDateTime.now());
					PO.setClearPO(true);
					PO.setClearDateTime(LocalDateTime.now());
					System.out.println("Wallet Balance: " + wallet);
					//	Invoke DMS API for PO Realization Posting
					dmsPORepo.save(PO);
					walletRepo.save(wallet);
				}	
			});
		}
		*/
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response> realizePendingPO(DMS_PO_DTO dto, BindingResult bindingResult,
			HttpServletResponse servletResponse) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
