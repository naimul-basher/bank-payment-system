package com.Web.BankPayment.util;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.Web.BankPayment.models.Customer;
import com.Web.BankPayment.repository.CustomerRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    private File customerFile;
    private CustomerRepository customerRepo;

    public BatchConfiguration(File customerBatchFile) {
    	this.customerFile = customerBatchFile;
    }
    
    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<Customer> reader() {
        return new FlatFileItemReaderBuilder<Customer>()
            .name("customerItemReader")
            //.resource(new FileSystemResource(customerFile))
            .resource(new ClassPathResource("sample-data"))
            .delimited()
            .names(new String[]{"customerVirtualAccountID", "customerName", "ERPCode", "POSCode"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{
                setTargetType(Customer.class);
            }})
            .build();
    }
    
    /*
    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }    
    */

    @Bean
    public RepositoryItemWriter<Customer> writer() {
    	return new RepositoryItemWriterBuilder<Customer>()
                .methodName("save")
                .repository(customerRepo)
                .build();
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importCustomerJob(/*JobCompletionNotificationListener listener, */Step step1) {
        return jobBuilderFactory.get("importCustomerJob")
            .incrementer(new RunIdIncrementer())
           // .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
            .<Customer, Customer> chunk(10)
            .reader(reader())
            .writer(writer())
            .build();
    }
    // end::jobstep[]
}
