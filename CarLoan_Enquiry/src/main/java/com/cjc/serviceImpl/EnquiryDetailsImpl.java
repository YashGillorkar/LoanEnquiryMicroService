package com.cjc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.repository.EnquiryDetailsRepository;
import com.cjc.serviceI.EnquiryDetailServiceI;
@Service
public class EnquiryDetailsImpl implements EnquiryDetailServiceI {
	
	
	@Autowired
	EnquiryDetailsRepository  enquiryDetailsRepository;

}
