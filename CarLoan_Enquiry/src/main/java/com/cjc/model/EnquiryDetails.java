package com.cjc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class EnquiryDetails {

	@Id
	private String enquiry_Id;
	private String full_Name;
	private String applicant_EmailId;
	private long contact_Number;
	private long alternateContactNumber;
	private int age;
	private String panCardNumber;
	
	@OneToOne
	private CibilDetails cibilDetails;

}
