package com.Web.BankPayment.util;

import java.util.Date;

public class BatchJobSummary {
	
	private Date createTime;
	private Date endTime;
	private Integer count;
	private String status;
	private String exitReason;
	private String input;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExitReason() {
		return exitReason;
	}
	public void setExitReason(String exitReason) {
		this.exitReason = exitReason;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	
	
}
