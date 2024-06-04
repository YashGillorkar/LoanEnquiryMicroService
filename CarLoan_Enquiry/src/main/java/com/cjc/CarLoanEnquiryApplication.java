package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CarLoanEnquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarLoanEnquiryApplication.class, args);
	}

}
