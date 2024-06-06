package com.cjc.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Data;
<<<<<<< HEAD
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> branch 'main' of https://github.com/YashGillorkar/LoanEnquiryMicroService.git

<<<<<<< HEAD

@Data
=======
@Data
@Setter
@Getter
>>>>>>> branch 'main' of https://github.com/YashGillorkar/LoanEnquiryMicroService.git
@Entity
public class CibilDetails  {
	
	@Id
	private String cibil_Id;
	private int cibil_score;
	private String remark;
	private boolean isApplicable;

}
