package com.cjc.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class EnquiryDetails {

	@Id
	private String enquiry_Id;
	private String first_Name;
	private String middle_Name;
	private String last_Name;
	private String applicant_EmailId;
	private long contact_Number;
	private long alternateContactNumber;
	private int age;
	private String enquiryStatus;
	
	@Column(unique=true)
	private String panCardNumber;

	

	@OneToOne(cascade = CascadeType.ALL)
	private CibilDetails cibilDetails;

}
