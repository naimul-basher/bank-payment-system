package com.Web.BankPayment.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {
	
	@Id
	private String customerWalletID;
	private Double balance;
	private LocalDateTime lastUpdateDateTime;
	
	public String getCustomerWalletID() {
		return customerWalletID;
	}
	public void setCustomerWalletID(String customerWalletID) {
		this.customerWalletID = customerWalletID;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public LocalDateTime getLastUpdateDateTime() {
		return lastUpdateDateTime;
	}
	public void setLastUpdateDateTime(LocalDateTime lastUpdateDateTime) {
		this.lastUpdateDateTime = lastUpdateDateTime;
	}
	
	@Override
	public String toString() {
		return "Wallet [customerWalletID=" + customerWalletID + ", balance=" + balance + ", lastUpdateDateTime="
				+ lastUpdateDateTime + "]";
	}
	
}
