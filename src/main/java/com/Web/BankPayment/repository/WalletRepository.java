package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Web.BankPayment.models.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, String> {
	
	public Wallet findBycustomerWalletID(String customerWalletID);

}
