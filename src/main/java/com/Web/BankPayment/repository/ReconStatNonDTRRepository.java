package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BankPayment.models.ReconStatusNonDTR;

@Repository
public interface ReconStatNonDTRRepository extends JpaRepository<ReconStatusNonDTR, Integer> {
	
	public ReconStatusNonDTR findBycustomerVirtualAccountID (String customerVirtualAccountID);
	public ReconStatusNonDTR findBychannelID (String channelID);
	public ReconStatusNonDTR findByreconcileBy (String reconcileBy);

}
