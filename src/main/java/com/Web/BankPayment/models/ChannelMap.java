package com.Web.BankPayment.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "channel_map")
public class ChannelMap {
	
	@Id
	private String channelID;
	private String channelName;
	private Boolean reconRealTime;			// 	{TRUE=realtime, FALSE=offline}
	private String customerCodePreferance; 	// 	{ERP, POS}
	private String channelDataSource; 		//	{Repo-identity}
	
	public String getChannelID() {
		return channelID;
	}
	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Boolean getReconRealTime() {
		return reconRealTime;
	}
	public void setReconRealTime(Boolean reconRealTime) {
		this.reconRealTime = reconRealTime;
	}
	public String getCustomerCodePreferance() {
		return customerCodePreferance;
	}
	public void setCustomerCodePreferance(String customerCodePreferance) {
		this.customerCodePreferance = customerCodePreferance;
	}
	public String getChannelDataSource() {
		return channelDataSource;
	}
	public void setChannelDataSource(String channelDataSource) {
		this.channelDataSource = channelDataSource;
	}
	
	@Override
	public String toString() {
		return "ChannelMap [channelID=" + channelID + ", channelName=" + channelName + ", reconRealTime="
				+ reconRealTime + ", customerCodePreferance=" + customerCodePreferance + ", channelDataSource="
				+ channelDataSource + "]";
	}
	
}
