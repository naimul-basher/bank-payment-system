package com.Web.BankPayment.serviceInterfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.Web.BankPayment.dto.Response;

public interface CustomerServiceInterface {
	
	public ResponseEntity<Response> saveCustomerList (MultipartFile customerFile,
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws Exception;

}
