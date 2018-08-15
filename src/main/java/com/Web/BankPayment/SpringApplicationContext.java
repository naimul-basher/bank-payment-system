package com.Web.BankPayment;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringApplicationContext {

	private static ApplicationContext CONTEXT;

	  public void setApplicationContext(ApplicationContext context) throws BeansException {
	    CONTEXT = context;
	  }

	  public static Object getBean(String beanName) {
	    return CONTEXT.getBean(beanName);
	  }
	
}
