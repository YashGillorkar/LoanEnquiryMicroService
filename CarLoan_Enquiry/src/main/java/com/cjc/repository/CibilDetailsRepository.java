package com.cjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.CibilDetails;

@Repository
public interface CibilDetailsRepository extends JpaRepository<CibilDetails,String>{

}
