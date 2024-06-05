package com.cjc.serviceI;

import java.util.List;

import com.cjc.model.EnquiryDetails;

public interface EnquiryDetailServiceI {

	void saveEnquiry(EnquiryDetails enquiry);

	List<EnquiryDetails> getAllEnquiries();

}
