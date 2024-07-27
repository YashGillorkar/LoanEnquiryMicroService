package com.cjc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.EnquiryDetails;

@Repository
public interface EnquiryDetailsRepository extends JpaRepository<EnquiryDetails,String> 
{
	List<EnquiryDetails> findAllByEnquiryStatus(String status );
	
}
