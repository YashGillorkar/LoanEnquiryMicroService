package com.cjc.pratice;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjc.model.EnquiryDetails;
import com.cjc.repository.EnquiryDetailsRepository;

public class RandomStringId {
	
	@Autowired
	EnquiryDetailsRepository enquiryDetailsRepository;
	
	
	public void idAutoGenerate(EnquiryDetails enquiry) {
		Random ramdom = new Random();
		String customId = "ENQ";

		int nextInt = ramdom.nextInt(100, 999);
		String newId = customId + nextInt;

		EnquiryDetails ed = enquiryDetailsRepository.findById(enquiry.getEnquiry_Id()).get();
		
		if (!(ed == null)) {
			enquiry.setEnquiry_Id(newId);
			System.exit(0);
		} else {
			idAutoGenerate(enquiry);
		}
	}

}
