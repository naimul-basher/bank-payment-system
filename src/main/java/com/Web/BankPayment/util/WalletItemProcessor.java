package com.Web.BankPayment.util;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.Web.BankPayment.models.Customer;
import com.Web.BankPayment.models.Wallet;

public class WalletItemProcessor implements ItemProcessor <Customer, Wallet>{

	private static final Logger log = LoggerFactory.getLogger(CustomerItemProcessor.class);

    @Override
    public Wallet process(final Customer customer) throws Exception {
        
        String customerVirtualAccountID = customer.getCustomerVirtualAccountID();        
        
        Wallet wallet = new Wallet();
        wallet.setCustomerWalletID(customerVirtualAccountID.substring(2));
        wallet.setBalance(0.0);
        wallet.setLastUpdateDateTime(LocalDateTime.now());

        log.info("Converting Virtual Account (" + customerVirtualAccountID + ") into Wallet-ID (" + customerVirtualAccountID.substring(2) + ")");

        return wallet;
    }
	
}
