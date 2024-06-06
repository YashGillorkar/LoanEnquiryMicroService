package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class CarLoanEnquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarLoanEnquiryApplication.class, args);
	}
	
	@Bean
	public RestTemplate m1()
	{
		RestTemplate rt= new RestTemplate();
		return rt;
	}
}
