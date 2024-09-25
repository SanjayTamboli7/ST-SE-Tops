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

import com.example.demo.model.Adminregistration;
import com.example.demo.model.Deliveryboy;
import com.example.demo.service.AdminregistrationService;

@RestController
public class AdminregistrationController {

	@SuppressWarnings("unused")
	@Autowired
	AdminregistrationService adminregistrationservice;
	
	@GetMapping("/adminregistration")
	private List<Adminregistration> getAlladminregistration() {
		return adminregistrationservice.getAllAdminregistration();
	}
	
	@GetMapping("adminregistration/{adminregistrationid}")
	private Adminregistration getadminregistration(@PathVariable("adminregistrationid") int adminregistrationid) {
		return adminregistrationservice.getAdminregistrationById(adminregistrationid);
	}

	@DeleteMapping("adminregistration/{adminregistrationid}")
	private void deletadminregistration(@PathVariable("adminregistrationid") int adminregistrationid) {
		adminregistrationservice.delete(adminregistrationid);
	}

	@PostMapping("/adminregistration")
	private int saveAdminregistration(@RequestBody Adminregistration adminregistration) {
		adminregistrationservice.saveOrUpdate(adminregistration);
		return adminregistration.getAdminrid();
	}

	@PutMapping("/adminregistration")
	private Adminregistration update(@RequestBody Adminregistration adminregistration) {
		adminregistrationservice.saveOrUpdate(adminregistration);
		return adminregistration;
	}
	
}
