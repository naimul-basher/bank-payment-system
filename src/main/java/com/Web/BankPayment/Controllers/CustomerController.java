package com.Web.BankPayment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Web.BankPayment.dto.CustomerDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.CustomerServiceInterface;

@RestController
public class CustomerController {
	
	private final CustomerServiceInterface customerInterface;
	
	@Autowired
	public CustomerController (final CustomerServiceInterface customerInterface) {
		this.customerInterface = customerInterface;
	}
	
//	@PostMapping("/api/v1/customer/add")
	public ResponseEntity<Response> saveCustomerList(@RequestBody @Validated CustomerDTO dto, 
			BindingResult bindingResult, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		System.out.println(dto);
		
		return customerInterface.saveCustomerList(dto, bindingResult, servletRequest, servletResponse);
	}
	
	/*
	@Autowired
    JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @PostMapping("/launch/file-name")
    public void launchByFileName(@RequestParam("file") String customerFileName) throws Exception {
     	
    	System.out.println(customerFileName);
    	
    	jobLauncher.run(job, new JobParametersBuilder()
                .addLong("launchTime", System.currentTimeMillis())
                .addString("fileName", "sample.csv")
                .toJobParameters());
    }
    
    @PostMapping("/launch/file")
    public void launchByFile(@RequestParam("file") MultipartFile customerFile, 
    		HttpServletRequest request) throws Exception {
     	
    	//System.out.println(customerFile.getOriginalFilename());
    	
    	//System.out.println(request.getServletContext().getRealPath("/") ); 
    	customerFile.transferTo(new File(request.getServletContext().getRealPath("/") + customerFile.getOriginalFilename()));
    	
    	jobLauncher.run(job, new JobParametersBuilder()
                .addLong("launchTime", System.currentTimeMillis())
                .addString("fileName", request.getServletContext().getRealPath("/") + customerFile.getOriginalFilename())
                .toJobParameters());

    }
	*/
	
}
