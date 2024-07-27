package com.cjc.serviceI;

import java.util.List;

import com.cjc.model.Admin;

public  interface AdminServiceI {

	public  Admin saveAdmin(Admin ad);

	public Admin getAdmin(String username, String password);

	public List<Admin> getAllData();
		
		
	

}
