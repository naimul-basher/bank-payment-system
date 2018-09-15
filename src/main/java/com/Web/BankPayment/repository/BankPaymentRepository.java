package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BankPayment.models.BankTransaction;

@Repository
public interface BankPaymentRepository extends JpaRepository<BankTransaction, Integer> {
	
	public BankTransaction findBybankTransactionID (String bankTransactionID);

}
