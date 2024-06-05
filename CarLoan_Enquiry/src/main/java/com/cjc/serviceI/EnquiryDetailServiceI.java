package com.cjc.serviceI;

import com.cjc.dto.ResponseDto;
import com.cjc.model.EnquiryDetails;

public interface EnquiryDetailServiceI {

	void saveEnquiry(EnquiryDetails enquiry);

	void deleteEnquiryData();

}
