package com.Web.BankPayment.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_transaction")
public class BankTransaction {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer commonTransactionID;
	private Integer bankTransactionID;
	private String customerVirtualAccountID;
	private String bankName;
	private Integer bankID;
	private Integer amount;
	
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime depositDateTime;
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime transactionDateTime;
	
	private String instrumentNumber;	// Check, Bank Draft, Pay-Order, EFTN, RTGS identity
	private String debitOrCredit;
	private String remarks;
	
	
	public Integer getCommonTransactionID() {
		return commonTransactionID;
	}
	public void setCommonTransactionID(Integer commonTransactionID) {
		this.commonTransactionID = commonTransactionID;
	}
	public Integer getBankTransactionID() {
		return bankTransactionID;
	}
	public void setBankTransactionID(Integer bankTransactionID) {
		this.bankTransactionID = bankTransactionID;
	}
	public String getCustomerVirtualAccountID() {
		return customerVirtualAccountID;
	}
	public void setCustomerVirtualAccountID(String customerVirtualAccountID) {
		this.customerVirtualAccountID = customerVirtualAccountID;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Integer getBankID() {
		return bankID;
	}
	public void setBankID(Integer bankID) {
		this.bankID = bankID;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public LocalDateTime getDepositDateTime() {
		return depositDateTime;
	}
	public void setDepositDateTime(LocalDateTime depositDateTime) {
		this.depositDateTime = depositDateTime;
	}
	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public String getInstrumentNumber() {
		return instrumentNumber;
	}
	public void setInstrumentNumber(String instrumentNumber) {
		this.instrumentNumber = instrumentNumber;
	}
	public String getDebitOrCredit() {
		return debitOrCredit;
	}
	public void setDebitOrCredit(String debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
