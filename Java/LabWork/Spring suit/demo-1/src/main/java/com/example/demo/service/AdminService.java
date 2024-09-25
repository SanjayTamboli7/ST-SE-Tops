package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.admin;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepository;

	public List<admin> getAlladminList() // all data fetch
	{
		List<admin> adminlists=new ArrayList<admin>();
		adminRepository.findAll().forEach(adminlists1 -> adminlists.add(adminlists1));
		return adminlists;
	}
	
	public admin getadminlistsById(int id) // Single wish list fetch
	{
		return adminRepository.findById(id).get(); 
	}

	public void saveOrUpdate(admin adminlist) // insert new book
	{
		adminRepository.save(adminlist);
	}

	public void delete(int id) 
	{
		adminRepository.deleteById(id);
	}
	
	public void update(admin adminlist, int adminlistid) 
	{
		adminRepository.save(adminlist);
	}

}
