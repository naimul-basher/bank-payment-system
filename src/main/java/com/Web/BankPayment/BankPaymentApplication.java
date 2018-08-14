package com.Web.BankPayment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.Web.BankPayment.util.TokenFilter;


@SpringBootApplication
@EnableAutoConfiguration
public class BankPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankPaymentApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public FilterRegistrationBean<TokenFilter> tokenFilter(){
	    FilterRegistrationBean<TokenFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new TokenFilter());
	    registrationBean.addUrlPatterns("/api/v1/users/*");
	         
	    return registrationBean;    
	}

}