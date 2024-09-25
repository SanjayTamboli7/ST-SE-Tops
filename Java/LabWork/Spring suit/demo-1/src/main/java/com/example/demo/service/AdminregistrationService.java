package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Adminregistration;
import com.example.demo.repository.AdminregistrationRepo;

@Service
public class AdminregistrationService {

	@Autowired
	AdminregistrationRepo adminregistrationRepository;

	public List<Adminregistration> getAllAdminregistration() // all data fetch
	{
		List<Adminregistration> adminregistration=new ArrayList<Adminregistration>();
		adminregistrationRepository.findAll().forEach(adminregistration1 -> adminregistration.add(adminregistration1));
		return adminregistration;
	}
	
	public Adminregistration getAdminregistrationById(int id) // Single dealer fetch
	{
		return adminregistrationRepository.findById(id).get();
	}

	public void saveOrUpdate(Adminregistration adminregistration) // insert new book
	{
		adminregistrationRepository.save(adminregistration);
	}

	public void delete(int id) 
	{
		adminregistrationRepository.deleteById(id);
	}
	
	public void update(Adminregistration adminregistration, int adminregistrationid) 
	{
		adminregistrationRepository.save(adminregistration);
	}

	public int getAdminregistration() {
		// TODO Auto-generated method stub
		return 0;
	}	

}
