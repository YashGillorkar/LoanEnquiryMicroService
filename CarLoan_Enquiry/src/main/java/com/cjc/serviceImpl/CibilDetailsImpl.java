package com.cjc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.repository.CibilDetailsRepository;
import com.cjc.serviceI.CibilDetailServiceI;
@Service
public class CibilDetailsImpl implements CibilDetailServiceI 
{
	@Autowired
	CibilDetailsRepository cibildetailsrepository;

}
