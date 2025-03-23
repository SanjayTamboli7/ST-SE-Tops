package repository;

import org.springframework.data.repository.CrudRepository;

import entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
