package com.Web.BankPayment.serviceImpl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.serviceInterfaces.CustomerServiceInterface;
import com.Web.BankPayment.util.BatchJobSummary;

import io.jsonwebtoken.Claims;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {
	
	@Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("customer-load-job")
    private Job job;
    
    private Integer jobStepCount;
    
	@Override
	public ResponseEntity<Response> saveCustomerList (MultipartFile customerFile,
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws Exception {
		
	    BatchJobSummary jobSummary = new BatchJobSummary();

		Response response = new Response();
		Claims claims = (Claims)servletRequest.getAttribute("claims");
		
		if(claims != null) {
			
			String destFileName = servletRequest.getServletContext().getRealPath("/") + customerFile.getOriginalFilename();
						
			customerFile.transferTo(new File(destFileName));
	    	
	    	JobExecution jobEx = jobLauncher.run(job, new JobParametersBuilder()
	                .addLong("launchTime", System.currentTimeMillis())
	                .addString("fileName", destFileName)
	                .toJobParameters());
	    		    	
	    	
	    	jobSummary.setCreateTime(jobEx.getCreateTime());
	    	jobSummary.setEndTime(jobEx.getEndTime());
	    	jobSummary.setExitReason(jobEx.getExitStatus().getExitDescription());
	    	jobSummary.setInput(jobEx.getJobParameters().getString("fileName"));
	    	jobSummary.setStatus(jobEx.getStatus().name());  	
	    	
	    	
	    	System.out.println( "[" + jobEx.getCreateTime().toString() + ":" + jobEx.getEndTime().toString() + "]\n" 
	    			+ "\n" + jobEx.getJobParameters() + "\n" + jobEx);

	    	jobEx.getStepExecutions()
	    		.stream()
	    		.filter( c -> c.getStepName().equals("step-customer") )
	    		.findFirst()
	    		.map( m -> jobStepCount = m.getWriteCount() );
			
	    	jobSummary.setCount(jobStepCount);
	    	
	    	//jobEx.getStepExecutions().forEach( steps -> { jobSummary += steps.getWriteCount() + " ";} );
	    	
			if(jobEx.getStatus().equals(BatchStatus.COMPLETED)) {
		    	
				response.setStatus("Created");
				response.setStatusCode(201);
				response.setMessage("New Customer Created");
				response.setContent(jobSummary);
				
				return new ResponseEntity<Response> (response, HttpStatus.CREATED);
			}
			else {
				response.setStatus("Incomplete");
				response.setStatusCode(501);
				response.setMessage("Customer Creation Job Failed");
				response.setContent(null);				
				
				return new ResponseEntity<Response> (response, HttpStatus.NOT_IMPLEMENTED);
			}
			
		}
		else {
			response.setStatus("Unauthorized");
			response.setStatusCode(401);
			response.setMessage("Unauthorized Access");
			response.setContent(null);
			
			return new ResponseEntity<Response> (response, HttpStatus.UNAUTHORIZED);
		}
		
	}
	

}
