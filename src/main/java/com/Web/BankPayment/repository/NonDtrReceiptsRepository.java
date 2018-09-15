package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BankPayment.models.NonDtrReceipts;

@Repository
public interface NonDtrReceiptsRepository extends JpaRepository<NonDtrReceipts, Integer>{
	
	public NonDtrReceipts findBypaymentBankName(String paymentBankName);
	public NonDtrReceipts findByisReconciled(Boolean isReconciled);
	public NonDtrReceipts findBycustomerVirtualAccountID(String customerVirtualAccountID);
	public NonDtrReceipts findBychannelID(String channelID);

}
