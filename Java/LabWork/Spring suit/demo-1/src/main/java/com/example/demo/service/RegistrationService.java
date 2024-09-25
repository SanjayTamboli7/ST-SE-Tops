package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dealers;
import com.example.demo.model.Registration;
import com.example.demo.repository.RegistrationRepo;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepo registrationRepository;
	
	public List<Registration> getAllregistration() // all data fetch
	{
		List<Registration> registration=new ArrayList<Registration>();
		registrationRepository.findAll().forEach(registration1 -> registration.add(registration1));
		return registration;
	}
	
	public Registration getRegistrationById(int id) // Single dealer fetch
	{
		return registrationRepository.findById(id).get(); 
	}

	public void saveOrUpdate(Registration registration) // insert new book
	{
		registrationRepository.save(registration);
	}

	public void delete(int id) 
	{
		registrationRepository.deleteById(id);
	}
	
	public void update(Registration registration, int registrationid) 
	{
		registrationRepository.save(registration);
	}
	
}
