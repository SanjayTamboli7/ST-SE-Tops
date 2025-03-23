package com.example.doc.hms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doc.hms.model.Doctormas;
import com.example.doc.hms.repository.DoctormasRepository;

@RestController
public class DoctormasController {
	
	private DoctormasRepository doctormasRepository;

	public DoctormasController(DoctormasRepository doctormasRepository) {
		//super();
		this.doctormasRepository = doctormasRepository;
	}
	
	@GetMapping("/doctors")
	public List<Doctormas> getAllDoctors() {
		return doctormasRepository.findAll();
	}

	@GetMapping("/doctors/{doctor_id}")
	public EntityModel<Doctormas> getDoctors(@PathVariable int doctor_id) {
		Optional<Doctormas> doctorMas = doctormasRepository.findById(doctor_id);
		EntityModel<Doctormas> entityModel = EntityModel.of(doctorMas.get()); 
		return entityModel;
	}
	
	@DeleteMapping("/doctors/{doctor_id}")
	public void deleteDoctor(@PathVariable int doctor_id) {
		doctormasRepository.deleteById(doctor_id);
	}
	
	@PostMapping("/doctors")
	public int saveDoctor(@RequestBody Doctormas doctors) {
		Doctormas savedDoctor = doctormasRepository.save(doctors);
		return savedDoctor.getDoctor_id();
	}
	
	
}
