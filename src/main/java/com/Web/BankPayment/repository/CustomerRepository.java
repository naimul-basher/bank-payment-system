package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Web.BankPayment.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	public Customer findbycustomerVirtualAccountID(String customerVirtualAccountID);

}
