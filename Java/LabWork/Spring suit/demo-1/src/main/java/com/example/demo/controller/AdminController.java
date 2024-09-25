package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.admin;
import com.example.demo.service.AdminService;

@RestController

public class AdminController {

	@SuppressWarnings("unused")
	@Autowired
	AdminService adminservice;
	@GetMapping("/admin")
	private List<admin> getAllAdmins() {
		return adminservice.getAlladminList();
	}
	
	@GetMapping("admin/{adminid}")
	private admin getAdmins(@PathVariable("adminid") int adminid) {
		return adminservice.getadminlistsById(adminid);
	}

	@DeleteMapping("admin/{adminid}")
	private void deleteadmin(@PathVariable("adminid") int adminid) {
		adminservice.delete(adminid);
	}

	@PostMapping("/admins")
	private int saveAdmin(@RequestBody admin admins) {
		adminservice.saveOrUpdate(admins);
		return admins.getAdminid();
	}

	@PutMapping("/admins")
	private admin update(@RequestBody admin admins) {
		adminservice.saveOrUpdate(admins);
		return admins;
	}

}
