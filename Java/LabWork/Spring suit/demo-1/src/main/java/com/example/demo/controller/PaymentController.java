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

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentServices;

@RestController
public class PaymentController {

	@SuppressWarnings("unused")
	@Autowired
	PaymentServices paymentservice; 
	@GetMapping("/payment")
	private List<Payment> getAllPayments() {
		return paymentservice.getAllpayment();
	}

	@GetMapping("payment/{paymentid}")
	private Payment getPayments(@PathVariable("paymentid") int paymentid) {
		return paymentservice.getPaymentById(paymentid);
	}
	
	@DeleteMapping("payment/{paymentid}")
	private void deletepayment(@PathVariable("paymentid") int paymentid) {
		paymentservice.delete(paymentid);
	}
	
	@PostMapping("/payment")
	private int savePayment(@RequestBody Payment payment) {
		paymentservice.saveOrUpdate(payment);
		return payment.getPaymentid();
	}

	@PutMapping("/payment")
	private Payment update(@RequestBody Payment payment) {
		paymentservice.saveOrUpdate(payment);
		return payment;
	}
	
}
