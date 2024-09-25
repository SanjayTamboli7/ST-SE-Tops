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

import com.example.demo.model.Deliveryboy;
import com.example.demo.service.DeliveryboyService;

@RestController
public class DeliveryboyController {

	@SuppressWarnings("unused")
	@Autowired
	DeliveryboyService deliveryboyservice; 

	@GetMapping("/deliveryboy")
	private List<Deliveryboy> getAlldeliveryboy() {
		return deliveryboyservice.getAlldeliveryboy();
	}
	
	@GetMapping("deliveryboy/{deliveryboyid}")
	private Deliveryboy getdeliveryboy(@PathVariable("deliveryboyid") int deliveryboyid) {
		return deliveryboyservice.getDeliveryboyById(deliveryboyid);
	}

	@DeleteMapping("deliveryboy/{deliveryboyid}")
	private void deletdeliveryboy(@PathVariable("deliveryboyid") int deliveryboyid) {
		deliveryboyservice.delete(deliveryboyid);
	}

	@PostMapping("/deliveryboy")
	private int saveDeliveryboy(@RequestBody Deliveryboy deliveryboy) {
		deliveryboyservice.saveOrUpdate(deliveryboy);
		return deliveryboy.getDeliveryboy();
	}

	@PutMapping("/deliveryboy")
	private Deliveryboy update(@RequestBody Deliveryboy deliveryboy) {
		deliveryboyservice.saveOrUpdate(deliveryboy);
		return deliveryboy;
	}
	
}
