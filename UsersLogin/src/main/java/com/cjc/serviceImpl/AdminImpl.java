package com.cjc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.model.Admin;
import com.cjc.repository.AdminRepo;
import com.cjc.serviceI.AdminServiceI;

@Service
public class AdminImpl implements AdminServiceI {

	@Autowired
	AdminRepo adminRepo;

	@Override
	public Admin saveAdmin(Admin ad) {
		return adminRepo.save(ad);

	}

	@Override
	public Admin getAdmin(String username, String password) {
		return adminRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<Admin> getAllData() {
		return adminRepo.findAll();
	}

}
