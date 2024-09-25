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

import com.example.demo.model.Customers;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@SuppressWarnings("unused")
	@Autowired
	CustomerService customerservice;
	@GetMapping("/customer")
	private List<Customers> getAllCustomer() {
		return customerservice.getAllcustomer();

	}
	
	@GetMapping("customer/{customerkid}")
	private Customers getcustomer(@PathVariable("customerid") int customerid) {
		return customerservice.getCustomersById(customerid);
	}

	@DeleteMapping("customer/{customerkid}")
	private void deletcustomer(@PathVariable("customerid") int customerid) {
		customerservice.delete(customerid);
	}

	@PostMapping("/customer")
	private int saveCustomer(@RequestBody Customers customer) {
		customerservice.saveOrUpdate(customer);
		return customer.getCustomerid();
	}

	@PutMapping("/customer")
	private Customers update(@RequestBody Customers customer) {
		customerservice.saveOrUpdate(customer);
		return customer;
	}
}
