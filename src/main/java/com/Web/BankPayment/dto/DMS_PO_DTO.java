package com.Web.BankPayment.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class DMS_PO_DTO {
	
	@NotEmpty
	private String purchaseOrderNumber;
	@NotEmpty
	private String customerPOSCode;
	@NotEmpty
	private String purchaseOrderType;
	@DateTimeFormat
	private LocalDateTime issueDateTime;
	@NotNull
	private Double amount;
	
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public String getCustomerPOSCode() {
		return customerPOSCode;
	}
	public void setCustomerPOSCode(String customerPOSCode) {
		this.customerPOSCode = customerPOSCode;
	}
	public String getPurchaseOrderType() {
		return purchaseOrderType;
	}
	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}
	public LocalDateTime getIssueDateTime() {
		return issueDateTime;
	}
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.issueDateTime = issueDateTime;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "DMS_PO_DTO [purchaseOrderNumber=" + purchaseOrderNumber + ", customerPOSCode=" + customerPOSCode
				+ ", purchaseOrderType=" + purchaseOrderType + ", issueDateTime=" + issueDateTime + ", amount=" + amount
				+ "]";
	}
	
}
