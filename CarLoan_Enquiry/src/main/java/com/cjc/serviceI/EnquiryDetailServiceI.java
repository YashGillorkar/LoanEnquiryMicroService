package com.cjc.serviceI;

import java.util.List;

import com.cjc.dto.ResponseDto;
import com.cjc.model.EnquiryDetails;

public interface EnquiryDetailServiceI {

	void saveEnquiry(EnquiryDetails enquiry);

	List<EnquiryDetails> getAllEnquiries();

	void deleteEnquiryData();

	void deleteOne(String id);



}
