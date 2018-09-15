package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BankPayment.models.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
	
	public Wallet findBycustomerWalletID(String customerWalletID);

}
