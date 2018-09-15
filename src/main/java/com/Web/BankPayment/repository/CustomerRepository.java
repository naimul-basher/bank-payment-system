package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BankPayment.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	public Customer findBycustomerVirtualAccountID(String customerVirtualAccountID);
	public Customer findBycustomerPOSCode(String customerPOSCode);

}
