package com.cjc.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class CibilDetails  {
	
	@Id
	private String cibil_Id;
	private int cibil_score;
	private String remark;
	private boolean isApplicable;

}
