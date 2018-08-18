package com.Web.BankPayment.util;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.Web.BankPayment.repository.CustomerRepository;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    FlatFileItemReader<Customer> customerFileReader;
    
    
	@Bean
    public Job job(Step step1) {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(FlatFileItemReader<Customer> reader, RepositoryItemWriter<Customer> writer) {
        return stepBuilderFactory.get("step1")
                .<Customer, Customer> chunk(10)
                .reader(reader)
//                .processor(processor())
                .writer(writer)
                .build();
    }
    
    @Bean
    @StepScope
    public FlatFileItemReader<Customer> reader(@Value("#{jobParameters['fileName']}") String fileName) throws MalformedURLException {
    	
    	String filePath = "file:/" + fileName;
    	//System.out.println("Inside Reader: " + filePath);

    	customerFileReader = new FlatFileItemReaderBuilder<Customer>()
            .name("customerItemReader")
            .resource(new UrlResource(filePath))
            .delimited()
            .names(new String[]{"customerVirtualAccountID", "customerName", "ERPCode", "POSCode"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{
                setTargetType(Customer.class);
            }})
            .build();
        
        return customerFileReader;
    }
    
    /*
    @Bean
	public CustomerItemProcessor processor() {
		return new CustomerItemProcessor();
	}
	*/

    @Bean
    public RepositoryItemWriter<Customer> writer() {
    	
    	RepositoryItemWriterBuilder<Customer> repoItemBuilder = new RepositoryItemWriterBuilder<Customer>();
    	repoItemBuilder.methodName("save");
    	repoItemBuilder.repository(customerRepo);
    	
    	return repoItemBuilder.build();
    }

}
