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

import com.example.demo.model.Addtocart;
import com.example.demo.service.Addtocartservice;

@RestController
public class AddtocartController {

	@SuppressWarnings("unused")
	@Autowired
	Addtocartservice addtocartservice;
	@GetMapping("/addtocart")
	
	private List<Addtocart> getAllAddtocarts() {
		return addtocartservice.getAllcart();
	}

	@GetMapping("addtocart/{cartid}")
	private Addtocart getCart(@PathVariable("cartid") int cartid) {
		return addtocartservice.getCartById(cartid);
	}

	@DeleteMapping("addtocart/{cartid}")
	private void deletecart(@PathVariable("cartid") int cartid) {
		addtocartservice.delete(cartid);
	}

	@PostMapping("/addtocart")
	private int saveAddtocart(@RequestBody Addtocart addtocart) {
		addtocartservice.saveOrUpdate(addtocart);
		return addtocart.getCartid();
	}
	
	@PutMapping("/addtocart")
	private Addtocart update(@RequestBody Addtocart addtocart) {
		addtocartservice.saveOrUpdate(addtocart);
		return addtocart;
	}	
}
