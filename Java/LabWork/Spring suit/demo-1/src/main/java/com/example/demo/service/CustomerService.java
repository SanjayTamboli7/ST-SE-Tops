package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customers;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepository;
	
	public List<Customers> getAllcustomer() // all data fetch
	{
		List<Customers> customers=new ArrayList<Customers>();
		customerRepository.findAll().forEach(customers1 -> customers.add(customers1));
		return customers;

	}

	public Customers getCustomersById(int id) // Single book fetch
	{
		return customerRepository.findById(id).get();

	}
	
	public void saveOrUpdate(Customers customers) // insert new book
	{
		customerRepository.save(customers);
	}
	
	public void delete(int id) 
	{
		customerRepository.deleteById(id);
	}
	
	public void update(Customers customers, int customerid) 
	{
		customerRepository.save(customers);
	}
}
