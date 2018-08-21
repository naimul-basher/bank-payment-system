package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Web.BankPayment.models.BankTransaction;

public interface BankPaymentRepository extends JpaRepository<BankTransaction, Integer> {
	
	public BankTransaction findBybankTransactionID (String bankTransactionID);

}
