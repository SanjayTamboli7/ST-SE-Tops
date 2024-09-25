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

import com.example.demo.model.Dealers;
import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;

@RestController
public class RegistrationController {

	@SuppressWarnings("unused")
	@Autowired
	RegistrationService registrationservice;
	
	@GetMapping("/registration")
	private List<Registration> getAllRegistration() {
		return registrationservice.getAllregistration();
	}
	
	@GetMapping("registration/{registrationid}")
	private Registration getregistration(@PathVariable("registrationid") int registrationid) {
		return registrationservice.getRegistrationById(registrationid);
	}

	@DeleteMapping("registration/{registrationid}")
	private void deletregistration(@PathVariable("registrationid") int registrationid) {
		registrationservice.delete(registrationid);
	}

	@PostMapping("/registration")
	private int saveRegistration(@RequestBody Registration registration) {
		registrationservice.saveOrUpdate(registration);
		return registration.getRid();
	}

	@PutMapping("/registration")
	private Registration update(@RequestBody Registration registration) {
		registrationservice.saveOrUpdate(registration);
		return registration;
	}

}
