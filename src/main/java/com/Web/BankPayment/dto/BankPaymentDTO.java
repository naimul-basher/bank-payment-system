package com.Web.BankPayment.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BankPaymentDTO {
	
	@NotNull
	private String bankTransactionID;
	@NotEmpty
	private String customerVirtualAccountID;
	@NotEmpty
	private String bankName;
	@NotNull
	private String bankID;
	@NotNull
	private String branchCode;
	@NotEmpty
	private String currencyCode;		
	@NotNull
	private Double amount;
	@NotEmpty
	private String paymentType;
	private String productCode;	
	@DateTimeFormat
	private LocalDateTime depositDateTime, transactionDateTime;
	private String instrumentNumber;	// Check, Bank Draft, Pay-Order, EFTN, RTGS identity
	@NotEmpty
	private String debitOrCredit;
	private String remarks;
	
	public String getBankTransactionID() {
		return bankTransactionID;
	}


	public void setBankTransactionID(String bankTransactionID) {
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


	public String getBankID() {
		return bankID;
	}


	public void setBankID(String bankID) {
		this.bankID = bankID;
	}


	public String getBranchCode() {
		return branchCode;
	}


	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	
	
	@Override
	public String toString() {
		return "BankPaymentDTO [bankTransactionID=" + bankTransactionID + ", customerVirtualAccountID="
				+ customerVirtualAccountID + ", bankName=" + bankName + ", bankID=" + bankID + ", branchCode="
				+ branchCode + ", currencyCode=" + currencyCode + ", amount=" + amount + ", paymentType=" + paymentType
				+ ", productCode=" + productCode + ", depositDateTime=" + depositDateTime + ", transactionDateTime="
				+ transactionDateTime + ", instrumentNumber=" + instrumentNumber + ", debitOrCredit=" + debitOrCredit
				+ ", remarks=" + remarks + "]";
	}



}
