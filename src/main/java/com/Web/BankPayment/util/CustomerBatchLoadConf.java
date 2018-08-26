package com.Web.BankPayment.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.net.MalformedURLException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import com.Web.BankPayment.models.Customer;
import com.Web.BankPayment.models.Wallet;
import com.Web.BankPayment.repository.CustomerRepository;
import com.Web.BankPayment.repository.WalletRepository;


@Configuration
@EnableBatchProcessing
public class CustomerBatchLoadConf {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private WalletRepository walletRepo;
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    FlatFileItemReader<Customer> customerFileReader;
    
    
	@Bean
	@Qualifier("customer-load-job")
    public Job job(Step stepCustomer, Step stepWallet) {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(stepCustomer)
                .next(stepWallet)
                .end()
                .build();
    }

    @Bean
    public Step stepCustomer (FlatFileItemReader<Customer> reader, RepositoryItemWriter<Customer> writerCustomer) {
        return stepBuilderFactory.get("step-customer")
                .<Customer, Customer> chunk(10)
                .reader(reader)
                .processor(new CustomerItemProcessor())
                .writer(writerCustomer)
                .build();
    }
    
    @Bean
    public Step stepWallet (FlatFileItemReader<Customer> reader, RepositoryItemWriter<Wallet> writerWallet) {
        return stepBuilderFactory.get("step-wallet")
                .<Customer, Wallet> chunk(10)
                .reader(reader)
                .processor(new WalletItemProcessor())
                .writer(writerWallet)
                .build();
    }
    
    @Bean
    @StepScope
    public FlatFileItemReader<Customer> reader(@Value("#{jobParameters['fileName']}") String fileName) throws MalformedURLException {
    	
    	//String filePath = "file:/" + fileName;

    	customerFileReader = new FlatFileItemReaderBuilder<Customer>()
            .name("customerItemReader")
            .resource(new UrlResource("file:/" + fileName))
            .delimited()
            .names(new String[]{"customerVirtualAccountID", "customerName", "ERPCode", "POSCode"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{
                setTargetType(Customer.class);
            }})
            .build();
        
        return customerFileReader;
    }
    
    
    @Bean
    public RepositoryItemWriter<Customer> writerCustomer() {
    	
    	RepositoryItemWriterBuilder<Customer> repoItemBuilder = new RepositoryItemWriterBuilder<Customer>();
    	repoItemBuilder.methodName("save");
    	repoItemBuilder.repository(customerRepo);
    	
    	return repoItemBuilder.build();
    }

    @Bean
    public RepositoryItemWriter<Wallet> writerWallet() {
    	
    	RepositoryItemWriterBuilder<Wallet> repoItemBuilder = new RepositoryItemWriterBuilder<Wallet>();
    	repoItemBuilder.methodName("save");
    	repoItemBuilder.repository(walletRepo);
    	
    	return repoItemBuilder.build();
    }

}
