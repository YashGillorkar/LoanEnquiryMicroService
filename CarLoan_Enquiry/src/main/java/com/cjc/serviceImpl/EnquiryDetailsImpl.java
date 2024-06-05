package com.cjc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.model.EnquiryDetails;
import com.cjc.repository.EnquiryDetailsRepository;
import com.cjc.serviceI.EnquiryDetailServiceI;

@Service
public class EnquiryDetailsImpl implements EnquiryDetailServiceI {

	@Autowired
	EnquiryDetailsRepository enquiryDetailsRepository;

	@Override
	public void saveEnquiry(EnquiryDetails enquiry) {

	}

	public List<EnquiryDetails> getAllEnquiries() {
		return enquiryDetailsRepository.findAll();

	}

	@Override
	public void deleteEnquiryData() {

		enquiryDetailsRepository.deleteAll();

	}

	@Override
	public void deleteOne(String id) {
		enquiryDetailsRepository.deleteById(id);
	}

}
