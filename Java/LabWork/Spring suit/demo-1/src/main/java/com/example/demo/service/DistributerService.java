package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Distributer;
import com.example.demo.repository.DistributerRepo;

@Service
public class DistributerService {

	@Autowired
	DistributerRepo distributerRepository;
	public List<Distributer> getAlldistributer() // all data fetch
	{
		List<Distributer> distributer=new ArrayList<Distributer>();
		distributerRepository.findAll().forEach(distributer1 -> distributer.add(distributer1));
		return distributer;
	}
	
	public Distributer getDistributerById(int id) // Single dealer fetch
	{
		return distributerRepository.findById(id).get(); 
	}

	public void saveOrUpdate(Distributer distributer) // insert new book
	{
		distributerRepository.save(distributer);
	}

	public void delete(int id) 
	{
		distributerRepository.deleteById(id);
	}
	
	public void update(Distributer distributer, int distributerid) 
	{
		distributerRepository.save(distributer);
	}	

}
