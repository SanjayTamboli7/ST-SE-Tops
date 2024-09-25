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

import com.example.demo.model.Distributer;
import com.example.demo.service.DistributerService;

@RestController
public class DistributerController {

	@SuppressWarnings("unused")
	@Autowired
	DistributerService distributerservice;
	
	@GetMapping("/distributer")
	private List<Distributer> getAllDistributer() {
		return distributerservice.getAlldistributer();
	}
	
	@GetMapping("distributer/{distributerid}")
	private Distributer getdistributer(@PathVariable("distributerid") int distributerid) {
		return distributerservice.getDistributerById(distributerid);
	}

	@DeleteMapping("distributer/{distributerid}")
	private void deletdistributer(@PathVariable("distributerid") int distributerid) {
		distributerservice.delete(distributerid);
	}

	@PostMapping("/distributer")
	private int saveDistributer(@RequestBody Distributer distributer) {
		distributerservice.saveOrUpdate(distributer);
		return distributer.getDistid();
	}

	@PutMapping("/distributer")
	private Distributer update(@RequestBody Distributer distributer) {
		distributerservice.saveOrUpdate(distributer);
		return distributer;
	}

}
