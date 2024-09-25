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

import com.example.demo.model.Dealers;
import com.example.demo.service.DealerService;

@RestController
public class DealerController {

	@SuppressWarnings("unused")
	@Autowired
	DealerService dealerservice;
	@GetMapping("/dealer")
	private List<Dealers> getAllDealer() {
		return dealerservice.getAlldealer();
	}
	
	@GetMapping("dealer/{dealerid}")
	private Dealers getdealer(@PathVariable("dealerid") int dealerid) {
		return dealerservice.getDealersById(dealerid);
	}

	@DeleteMapping("dealer/{dealerid}")
	private void deletdealer(@PathVariable("dealerid") int dealerid) {
		dealerservice.delete(dealerid);
	}

	@PostMapping("/dealer")
	private int saveDealer(@RequestBody Dealers dealer) {
		dealerservice.saveOrUpdate(dealer);
		return dealer.getDealerid();
	}

	@PutMapping("/dealer")
	private Dealers update(@RequestBody Dealers dealer) {
		dealerservice.saveOrUpdate(dealer);
		return dealer;
	}
	
}
