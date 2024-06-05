package com.cjc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.dto.ResponseDto;
import com.cjc.model.EnquiryDetails;

import com.cjc.serviceI.EnquiryDetailServiceI;

@RestController
public class EnquiryDetailsController {

	@Autowired
	EnquiryDetailServiceI enquiryDetailServiceI;

	@PostMapping("/postEnquiry")
	public ResponseEntity<ResponseDto> postEnquiry(@RequestBody EnquiryDetails enquiry) {
		enquiryDetailServiceI.saveEnquiry(enquiry);
		ResponseDto response = new ResponseDto("The Data has submitted. We will update you shortly", new Date());
		return new ResponseEntity<ResponseDto>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteAllEnquiryData")
	public ResponseEntity<ResponseDto> deleteAllData() {

		enquiryDetailServiceI.deleteEnquiryData();

		ResponseDto response = new ResponseDto(" All Enquiry Data Is Deleted ", new Date());

		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);

	} 
	
		@DeleteMapping("/deleteSingleEnquiry/{id}")
		public ResponseEntity<ResponseDto> deleted(@PathVariable String id)
		{
			enquiryDetailServiceI.deleteOne(id);
			ResponseDto respose=new ResponseDto(" ID deleted successfully: "+id, new Date());
			return new ResponseEntity<ResponseDto>(respose,HttpStatus.OK);
		}
}
