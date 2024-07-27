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

	void updateById(String id, EnquiryDetails enquiryDetails);

	CibilDetails getCibilDetails(String panCardNumber);

	List<EnquiryDetails> getAllDataByStatus(String enqs);

	void updateStatus(String enquiryId, String enquiryStatus);

	void loanEnquiryApproval(String enquiry_Id, String enquiryStatus);

	void loanEnquiryRejected(String enquiry_Id, String enquiryStatus);

	
	
	


}
