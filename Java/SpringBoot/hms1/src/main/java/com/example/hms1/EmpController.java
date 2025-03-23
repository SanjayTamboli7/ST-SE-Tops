package com.example.hms1;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

	private EmpRepository empRepository;

	public EmpController(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	@GetMapping("/Emps")
	public List<Emp> getAllEmps() {
		return empRepository.findAll();
	}

	@GetMapping("/Emps/{emp_id}")
	public EntityModel<Emp> getEmps(@PathVariable int emp_id) {
		Optional<Emp> emp = empRepository.findById(emp_id);
		EntityModel<Emp> entityModel = EntityModel.of(emp.get());
		return entityModel;
	}

	@DeleteMapping("/Emps/{emp_id}")
	public void deleteEmp(@PathVariable int emp_id) {
		empRepository.deleteById(emp_id);
	}

	@PostMapping("/Emps")
	public int saveEmp(@RequestBody Emp emp) {
		Emp saveEmp = empRepository.save(emp);
		return saveEmp.getEmp_id();
	}
	
}
