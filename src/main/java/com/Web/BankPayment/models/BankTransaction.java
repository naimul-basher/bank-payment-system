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
	private Integer branchCode;
	private String currencyCode;				//	Code = {BDT, USD, NOK}
	private Integer amount;
	private String paymentType;					//	Type = {Cash, Pay-Order, Bank Draft, EFTB, RTGS}
	private String productCode;					//	GP1001
	
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime depositDateTime;		// 	aka value-date
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime transactionDateTime;	//	aka bank-date 
	
	private String instrumentNumber;			// Check, Bank Draft, Pay-Order, EFTN, RTGS identity
	private String debitOrCredit;
	private String remarks;						//	Transaction Details
	
	
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
	public Integer getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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
	@Override
	public String toString() {
		return "BankTransaction [commonTransactionID=" + commonTransactionID + ", bankTransactionID="
				+ bankTransactionID + ", customerVirtualAccountID=" + customerVirtualAccountID + ", bankName="
				+ bankName + ", bankID=" + bankID + ", branchCode=" + branchCode + ", currencyCode=" + currencyCode
				+ ", amount=" + amount + ", paymentType=" + paymentType + ", productCode=" + productCode
				+ ", depositDateTime=" + depositDateTime + ", transactionDateTime=" + transactionDateTime
				+ ", instrumentNumber=" + instrumentNumber + ", debitOrCredit=" + debitOrCredit + ", remarks=" + remarks
				+ "]";
	}
	
	

}
