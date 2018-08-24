package com.Web.BankPayment.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DMS_purchase_order")
public class DMS_PO {
	
	@Id
	private String purchaseOrderNumber;
	private String customerPOSCode;
	private String purchaseOrderType;
	private LocalDateTime issueDateTime, clearDateTime;
	private Boolean clearPO;
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
	public LocalDateTime getClearDateTime() {
		return clearDateTime;
	}
	public void setClearDateTime(LocalDateTime clearDateTime) {
		this.clearDateTime = clearDateTime;
	}
	public Boolean getClearPO() {
		return clearPO;
	}
	public void setClearPO(Boolean clearPO) {
		this.clearPO = clearPO;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "DMS_PO [purchaseOrderNumber=" + purchaseOrderNumber + ", customerPOSCode=" + customerPOSCode
				+ ", purchaseOrderType=" + purchaseOrderType + ", issueDateTime=" + issueDateTime + ", clearDateTime="
				+ clearDateTime + ", clearPO=" + clearPO + ", amount=" + amount + "]";
	}		
}
