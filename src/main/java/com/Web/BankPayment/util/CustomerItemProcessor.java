package com.Web.BankPayment.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.Web.BankPayment.models.Customer;


public class CustomerItemProcessor implements ItemProcessor <Customer, Customer>{

	private static final Logger log = LoggerFactory.getLogger(CustomerItemProcessor.class);

    @Override
    public Customer process(final Customer customer) throws Exception {
        
        String customerVirtualAccountID = customer.getCustomerVirtualAccountID();        
        
        customer.setCustomerWalletID(customerVirtualAccountID.substring(2));
        customer.setChannelID(customerVirtualAccountID.substring(2, 4));
        
        log.info("Converting Virtual Account (" + customerVirtualAccountID + ") into Channel-ID (" + customerVirtualAccountID.substring(2, 4) + ")");

        return customer;
    }
	
}
