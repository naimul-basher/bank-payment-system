package com.Web.BankPayment.serviceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.SpringApplicationContext;
import com.Web.BankPayment.dto.CustomerDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.repository.CustomerRepository;
import com.Web.BankPayment.repository.WalletRepository;
import com.Web.BankPayment.serviceInterfaces.CustomerServiceInterface;
import com.Web.BankPayment.util.BatchConfiguration;

import io.jsonwebtoken.Claims;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServiceInterface {

	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;

	private final CustomerRepository customerRepo;
	private final WalletRepository walletRepo;
	
	@Autowired
	public CustomerServiceImpl (final CustomerRepository customerRepo, final WalletRepository walletRepo) {
		this.customerRepo = customerRepo;
		this.walletRepo = walletRepo;
	}

	@Override
	public ResponseEntity<Response> saveCustomerList(CustomerDTO dto, BindingResult bindingResult,
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		Response response = new Response();
		Claims claims = (Claims)servletRequest.getAttribute("claims");
		
		if(claims != null) {

			/*
			try {
				job = (Job) SpringApplicationContext.getBean("importCustomerJob");
				JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
				BatchStatus batchStatus = jobExecution.getStatus();
			} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
					| JobParametersInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			*/
			/*
			ApplicationContext ctx;
			
			ConfigurableApplicationContext ctx = new ConfigurableApplicationContext(BatchConfiguration.class);
			
			this.jobLauncher
			
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
			 
	        MainJobLauncher main = context.getBean(MainJobLauncher.class);
	 
	        JobExecution jobExecution = main.jobLauncher.run(main.importUserJob, new JobParameters());
	 
	        MainHelper.reportResults(jobExecution);
	        MainHelper.reportPeople(context.getBean(JdbcTemplate.class));
			*/
			
			response.setStatus("Created");
			response.setStatusCode(201);
			response.setMessage("New Transaction Created");
			response.setContent(null);
			
			return new ResponseEntity<Response> (response, HttpStatus.CREATED);
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
