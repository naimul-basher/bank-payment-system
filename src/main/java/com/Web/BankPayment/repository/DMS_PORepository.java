package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Web.BankPayment.models.DMS_PO;

public interface DMS_PORepository extends JpaRepository<DMS_PO, String> {
	
	public DMS_PO findByclearPO (Boolean clearPO);
	public DMS_PO findBycustomerPOSCode (String customerPOSCode);
	public DMS_PO findBypurchaseOrderNumber (String purchaseOrderNumber);
}
