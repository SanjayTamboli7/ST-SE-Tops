package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Addtocart;
import com.example.demo.repository.AddtocartRepo;

@Service
public class Addtocartservice {

	@Autowired
	AddtocartRepo addtocartRepository;
	
	public List<Addtocart> getAllcart() // all data fetch
	{
		List<Addtocart> addtocarts=new ArrayList<Addtocart>();
		addtocartRepository.findAll().forEach(addtocart1 -> addtocarts.add(addtocart1));
		return addtocarts;
	}
	
	public Addtocart getCartById(int id) // Single payment fetch
	{
		return addtocartRepository.findById(id).get(); 
	}

	public void saveOrUpdate(Addtocart addtocart) // insert new book
	{
		addtocartRepository.save(addtocart);
	}
	
	public void delete(int id) 
	{
		addtocartRepository.deleteById(id);
	}
	
	public void update(Addtocart addtocart, int paymentid) 
	{
		addtocartRepository.save(addtocart);
	}

}
