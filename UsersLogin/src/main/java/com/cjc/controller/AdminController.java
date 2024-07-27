package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.model.Admin;
import com.cjc.serviceI.AdminServiceI;

@CrossOrigin("*")
@RestController
public class AdminController {
	@Autowired
	AdminServiceI adminServiceI;

	@PostMapping("/saveAdmin")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin ad) {
		Admin admin = adminServiceI.saveAdmin(ad);
		System.out.println();
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@GetMapping("/getAdmin/{username}/{password}")
	public ResponseEntity<Admin> getAdmin(@PathVariable String username, @PathVariable String password) {
		Admin admin = adminServiceI.getAdmin(username, password);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Admin>> getAdmin() {
		List<Admin> admin = adminServiceI.getAllData();
		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}

}