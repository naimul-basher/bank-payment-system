package com.Web.BankPayment.serviceImpl;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.Web.BankPayment.dto.BankPaymentDTO;
import com.Web.BankPayment.dto.Response;
import com.Web.BankPayment.models.BankTransaction;
import com.Web.BankPayment.models.Wallet;
import com.Web.BankPayment.repository.BankPaymentRepository;
import com.Web.BankPayment.repository.WalletRepository;
import com.Web.BankPayment.serviceInterfaces.BankPaymentServiceInterface;


@Service
@Transactional
public class BankPaymentServiceImpl implements BankPaymentServiceInterface {

	private final BankPaymentRepository bankPaymentRepo;
	private final WalletRepository walletRepo;
	private final ModelMapper modelMapper;
	private BankTransaction transaction;
	private Wallet wallet;

	@Autowired
	public BankPaymentServiceImpl (final BankPaymentRepository bankPaymentRepo, final ModelMapper modelMapper, 
			 final WalletRepository walletRepo) {
		this.bankPaymentRepo = bankPaymentRepo;
		this.walletRepo = walletRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<Response> saveBankTransaction(BankPaymentDTO dto, BindingResult bindingResult,
			HttpServletResponse servletResponse) {
		
		Response response = new Response();
		
		if(bindingResult.hasErrors()) {
			response.setStatus("Bad Request");
			response.setStatusCode(400);
			response.setMessage("Initial Validation Failed");
			response.setContent(bindingResult.getAllErrors());
			
			return new ResponseEntity<Response> (response, HttpStatus.BAD_REQUEST);
		}
		else {

			if ( (transaction = bankPaymentRepo.findBybankTransactionID(dto.getBankTransactionID()) ) != null &&
					transaction.getBankID().matches(dto.getBankID()) ) {

				System.out.println(transaction);
				response.setStatus("Duplicate");
				response.setStatusCode(409);
				response.setMessage("Transaction Duplicate");
				response.setContent(null);
				
				return new ResponseEntity<Response> (response, HttpStatus.CONFLICT);
			}
			else {
				transaction = new BankTransaction();
				wallet = new Wallet();
				
				modelMapper.map(dto,  transaction);
				transaction.setChannelID(dto.getCustomerVirtualAccountID().substring(2, 4));
								
				if ( (wallet = walletRepo.findBycustomerWalletID(dto.getCustomerVirtualAccountID().substring(2)) ) != null ) {

					wallet.setBalance(wallet.getBalance() + dto.getAmount());
					wallet.setLastUpdateDateTime(LocalDateTime.now());
					transaction.setIsSettled(true);

					System.out.println(wallet);
					walletRepo.save(wallet);
				}
				else 
					transaction.setIsSettled(false);
				
				System.out.println(transaction);
				bankPaymentRepo.save(transaction);
				
				response.setStatus("Created");
				response.setStatusCode(201);
				response.setMessage("New Transaction Created");
				response.setContent(transaction);
				
				return new ResponseEntity<Response> (response, HttpStatus.CREATED);				
			}
			
		}

	}

}
