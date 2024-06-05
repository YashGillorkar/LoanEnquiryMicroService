package com.cjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.serviceI.CibilDetailServiceI;

@RestController
public class CibilDetailsController 
{
	@Autowired
	CibilDetailServiceI cibildetailsi;

}
