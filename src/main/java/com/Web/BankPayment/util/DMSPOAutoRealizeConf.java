package com.Web.BankPayment.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Web.BankPayment.models.DMS_PO;
import com.Web.BankPayment.models.Wallet;
import com.Web.BankPayment.repository.CustomerRepository;
import com.Web.BankPayment.repository.DMS_PORepository;
import com.Web.BankPayment.repository.WalletRepository;


@Component
public class DMSPOAutoRealizeConf {
	
	@Autowired
	private DMS_PORepository dmsPORepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private WalletRepository walletRepo;
	
	List<DMS_PO> pendingPOList = new ArrayList<DMS_PO>();
	
	@Scheduled(fixedRate = 10000)		// 10 seconds interval
	public void DMSPOAutoReconcile() {
				
		pendingPOList = dmsPORepo.findByclearPO(false);
		
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
			
	}
	
}
