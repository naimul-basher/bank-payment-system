package com.Web.BankPayment.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	private String customerVirtualAccountID;
	private String customerName;
	private String ERPCode;
	private String POSCode;
	private String customerWalletID;
	private String channelID;
	
	public String getCustomerVirtualAccountID() {
		return customerVirtualAccountID;
	}
	public void setCustomerVirtualAccountID(String customerVirtualAccountID) {
		this.customerVirtualAccountID = customerVirtualAccountID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getERPCode() {
		return ERPCode;
	}
	public void setERPCode(String eRPCode) {
		ERPCode = eRPCode;
	}
	public String getPOSCode() {
		return POSCode;
	}
	public void setPOSCode(String pOSCode) {
		POSCode = pOSCode;
	}
	public String getCustomerWalletID() {
		return customerWalletID;
	}
	public void setCustomerWalletID(String customerWalletID) {
		this.customerWalletID = customerWalletID;
	}
	public String getChannelID() {
		return channelID;
	}
	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
	@Override
	public String toString() {
		return "Customer [customerVirtualAccountID=" + customerVirtualAccountID + ", customerName=" + customerName
				+ ", ERPCode=" + ERPCode + ", POSCode=" + POSCode + ", customerWalletID=" + customerWalletID
				+ ", channelID=" + channelID + "]";
	}
	
	

}
