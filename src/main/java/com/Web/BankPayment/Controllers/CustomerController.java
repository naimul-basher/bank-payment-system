package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.CustomerServiceInterface;

@RestController
public class CustomerController {
	
	private final CustomerServiceInterface customerInterface;
	
	@Autowired
	public CustomerController (final CustomerServiceInterface customerInterface) {
		this.customerInterface = customerInterface;
	}
	
	@PostMapping("/api/v1/customer/add")
	public ResponseEntity<Response> saveCustomerList(@RequestParam("file") MultipartFile customerFile, 
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws Exception {
				
		return customerInterface.saveCustomerList(customerFile, servletRequest, servletResponse);
	}
	
	/*

    @PostMapping("/launch/file-name")
    public void launchByFileName(@RequestParam("file") String customerFileName) throws Exception {
     	
    	System.out.println(customerFileName);
    	
    	jobLauncher.run(job, new JobParametersBuilder()
                .addLong("launchTime", System.currentTimeMillis())
                .addString("fileName", "sample.csv")
                .toJobParameters());
    }
    
	*/
	
}
