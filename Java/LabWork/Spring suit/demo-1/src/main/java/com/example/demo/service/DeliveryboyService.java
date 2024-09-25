package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Deliveryboy;
import com.example.demo.repository.DeliveryboyRepo;

@Service
public class DeliveryboyService {

	@Autowired
	DeliveryboyRepo deliveryboyRepository;

	public List<Deliveryboy> getAlldeliveryboy() // all data fetch
	{
		List<Deliveryboy> deliveryboy=new ArrayList<Deliveryboy>();
		deliveryboyRepository.findAll().forEach(deliveryboy1 -> deliveryboy.add(deliveryboy1));
		return deliveryboy;
	}
	
	public Deliveryboy getDeliveryboyById(int id) // Single dealer fetch
	{
		return deliveryboyRepository.findById(id).get();
	}

	public void saveOrUpdate(Deliveryboy deliveryboy) // insert new book
	{
		deliveryboyRepository.save(deliveryboy);
	}

	public void delete(int id) 
	{
		deliveryboyRepository.deleteById(id);
	}
	
	public void update(Deliveryboy deliveryboy, int deliveryboyid) 
	{
		deliveryboyRepository.save(deliveryboy);
	}	
	
}
