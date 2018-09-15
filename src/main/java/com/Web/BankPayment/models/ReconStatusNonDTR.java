package com.Web.BankPayment.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recon_status_non_dtr")
public class ReconStatusNonDTR {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer reconcileID;
	private String customerVirtualAccountID;
	private Integer commonTransactionID;
	private String channelID;
	
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime reconcileDateTime;
	
	private String reconcileBy;					// User logged in

	public Integer getReconcileID() {
		return reconcileID;
	}

	public void setReconcileID(Integer reconcileID) {
		this.reconcileID = reconcileID;
	}

	public String getCustomerVirtualAccountID() {
		return customerVirtualAccountID;
	}

	public void setCustomerVirtualAccountID(String customerVirtualAccountID) {
		this.customerVirtualAccountID = customerVirtualAccountID;
	}

	public Integer getCommonTransactionID() {
		return commonTransactionID;
	}

	public void setCommonTransactionID(Integer commonTransactionID) {
		this.commonTransactionID = commonTransactionID;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}

	public LocalDateTime getReconcileDateTime() {
		return reconcileDateTime;
	}

	public void setReconcileDateTime(LocalDateTime reconcileDateTime) {
		this.reconcileDateTime = reconcileDateTime;
	}

	public String getReconcileBy() {
		return reconcileBy;
	}

	public void setReconcileBy(String reconcileBy) {
		this.reconcileBy = reconcileBy;
	}

	@Override
	public String toString() {
		return "ReconStatusNonDTR [reconcileID=" + reconcileID + ", customerVirtualAccountID="
				+ customerVirtualAccountID + ", commonTransactionID=" + commonTransactionID + ", channelID=" + channelID
				+ ", reconcileDateTime=" + reconcileDateTime + ", reconcileBy=" + reconcileBy + "]";
	}

}
