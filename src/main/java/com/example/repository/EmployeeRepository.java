package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	// find all employees in a given department
	public List<Employee> findByDeptEmployeesIdDeptNumber(String deptNumber);
	
	// find employee that is manager of a given department
	public List<Employee> findByDeptManagersIdDeptNumber(String deptNumber);
}
