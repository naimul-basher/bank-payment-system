package com.Web.BankPayment.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "non_dtr_receipts")
public class NonDtrReceipts {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer commonReceiptID;
	private String receiptNumber;
	
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime issueDateTime, depositDateTime, createdDateTime, reconcileDateTime;
	
	private String paymentBankName;
	private Double receiptAmount;
	private Boolean isReconciled;				//{Yes, No}
	private String customerVirtualAccountID;
	private String channelID;
	private String instrumentNumber;
	private String paymentMethod; 				//{Cash, PO, Draft, EFTN}
	
	public Integer getCommonReceiptID() {
		return commonReceiptID;
	}
	public void setCommonReceiptID(Integer commonReceiptID) {
		this.commonReceiptID = commonReceiptID;
	}
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public LocalDateTime getIssueDateTime() {
		return issueDateTime;
	}
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.issueDateTime = issueDateTime;
	}
	public LocalDateTime getDepositDateTime() {
		return depositDateTime;
	}
	public void setDepositDateTime(LocalDateTime depositDateTime) {
		this.depositDateTime = depositDateTime;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public LocalDateTime getReconcileDateTime() {
		return reconcileDateTime;
	}
	public void setReconcileDateTime(LocalDateTime reconcileDateTime) {
		this.reconcileDateTime = reconcileDateTime;
	}
	public String getPaymentBankName() {
		return paymentBankName;
	}
	public void setPaymentBankName(String paymentBankName) {
		this.paymentBankName = paymentBankName;
	}
	public Double getReceiptAmount() {
		return receiptAmount;
	}
	public void setReceiptAmount(Double receiptAmount) {
		this.receiptAmount = receiptAmount;
	}
	public Boolean getIsReconciled() {
		return isReconciled;
	}
	public void setIsReconciled(Boolean isReconciled) {
		this.isReconciled = isReconciled;
	}
	public String getCustomerVirtualAccountID() {
		return customerVirtualAccountID;
	}
	public void setCustomerVirtualAccountID(String customerVirtualAccountID) {
		this.customerVirtualAccountID = customerVirtualAccountID;
	}
	public String getChannelID() {
		return channelID;
	}
	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
	public String getInstrumentNumber() {
		return instrumentNumber;
	}
	public void setInstrumentNumber(String instrumentNumber) {
		this.instrumentNumber = instrumentNumber;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Override
	public String toString() {
		return "NonDtrReceipts [commonReceiptID=" + commonReceiptID + ", receiptNumber=" + receiptNumber
				+ ", issueDateTime=" + issueDateTime + ", depositDateTime=" + depositDateTime + ", createdDateTime="
				+ createdDateTime + ", reconcileDateTime=" + reconcileDateTime + ", paymentBankName=" + paymentBankName
				+ ", receiptAmount=" + receiptAmount + ", isReconciled=" + isReconciled + ", customerVirtualAccountID="
				+ customerVirtualAccountID + ", channelID=" + channelID + ", instrumentNumber=" + instrumentNumber
				+ ", paymentMethod=" + paymentMethod + "]";
	}

}
