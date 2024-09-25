package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import com.example.demo.model.Customers;*/
import com.example.demo.model.Dealers;
import com.example.demo.repository.DealerRepo;

@Service
public class DealerService {

	@Autowired
	DealerRepo dealerRepository;
	
	public List<Dealers> getAlldealer() // all data fetch
	{
		List<Dealers> dealers=new ArrayList<Dealers>();
		dealerRepository.findAll().forEach(dealers1 -> dealers.add(dealers1));
		return dealers;
	}

	public Dealers getDealersById(int id) // Single dealer fetch
	{
		return dealerRepository.findById(id).get(); 
	}
	
	public void saveOrUpdate(Dealers dealers) // insert new book
	{
		dealerRepository.save(dealers);
	}
	
	public void delete(int id) 
	{
		dealerRepository.deleteById(id);
	}
	
	public void update(Dealers dealers, int dealerid) 
	{
		dealerRepository.save(dealers);
	}

}
