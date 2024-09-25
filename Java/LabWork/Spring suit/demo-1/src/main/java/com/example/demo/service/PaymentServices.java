package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepo;

@Service
public class PaymentServices {

	@Autowired
	PaymentRepo paymentRepository;
	
	public List<Payment> getAllpayment() // all data fetch
	{
		List<Payment> payments=new ArrayList<Payment>();
		paymentRepository.findAll().forEach(payments1 -> payments.add(payments1));
		return payments;
	}
	
	public Payment getPaymentById(int id) // Single payment fetch
	{
		return paymentRepository.findById(id).get(); 
	}

	public void saveOrUpdate(Payment payment) // insert new book
	{
		paymentRepository.save(payment);
	}
	
	public void delete(int id) 
	{
		paymentRepository.deleteById(id);
	}
	
	public void update(Payment payment, int paymentid) 
	{
		paymentRepository.save(payment);
	}

}
