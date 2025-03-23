package Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Model.Employee;
import Repository.EmployeeRepository;

@RestController
public class EmployeeController {

	private EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PostMapping("/employees")
	public int saveEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = employeeRepository.save(employee);
		return saveEmployee.getEmp_id();
	}
}
