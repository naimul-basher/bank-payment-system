package com.Web.BankPayment.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BankPaymentDTO {
	
	@NotNull
	private Integer bankTransactionID;
	@NotEmpty
	private String customerVirtualAccountID;
	@NotEmpty
	private String bankName;
	@NotNull
	private Integer bankID;
	@NotNull
	private Integer amount;
	@DateTimeFormat
	private LocalDateTime depositDateTime, transactionDateTime;
	private String instrumentNumber;	// Check, Bank Draft, Pay-Order, EFTN, RTGS identity
	@NotEmpty
	private String debitOrCredit;
	private String remarks;
	
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
	
	@Override
	public String toString() {
		return "BankPaymentDTO [bankTransactionID=" + bankTransactionID + ", customerVirtualAccountID="
				+ customerVirtualAccountID + ", bankName=" + bankName + ", bankID=" + bankID + ", amount=" + amount
				+ ", depositDateTime=" + depositDateTime + ", transactionDateTime=" + transactionDateTime
				+ ", instrumentNumber=" + instrumentNumber + ", debitOrCredit=" + debitOrCredit + ", remarks=" + remarks
				+ "]";
	}
	
}
