package com.cjc.serviceI;

import java.util.List;

import com.cjc.model.CibilDetails;
import com.cjc.model.EnquiryDetails;

public interface EnquiryDetailServiceI {

	void saveEnquiry(EnquiryDetails enquiry);

	List<EnquiryDetails> getAllEnquiries();

	void deleteEnquiryData();

	void deleteOne(String id);
	
	EnquiryDetails getSingleData(String enquiry_Id);

	
	


}
