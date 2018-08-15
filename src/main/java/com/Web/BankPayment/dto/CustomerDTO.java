package com.Web.BankPayment.dto;

import java.io.File;

public class CustomerDTO {
	
	private File customerFile;

	public File getCustomerFile() {
		return customerFile;
	}

	public void setCustomerFile(File customerFile) {
		this.customerFile = customerFile;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerFile=" + customerFile + "]";
	}
	
}
