package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	public Employee findOne(Integer empNumber) {
		Employee emp = empRepository.findOne(empNumber);
		if (null == emp) {
			throw new EmployeeNotFoundException
				("Employee with Id : " + empNumber + " not found");
		}
		return  emp;
	}
	
	public Employee save(Employee emp) {
		Employee savedEmp = empRepository.save(emp);
		return savedEmp;
	}
	
	public List<Employee> findAllEmployees() {
		return (List<Employee>) empRepository.findAll();
	}
	
	public Employee updateEmployee(Integer empNumber, Employee emp) {
		Employee updatedEmployee = null;
		if (null != emp && empNumber.equals(emp.getEmpNumber())) {
			if (empRepository.exists(empNumber)) {
				updatedEmployee = empRepository.save(emp);
			} else {
				throw new EmployeeNotFoundException
				("Employee with Id : " + empNumber + " not found");
			}
		} 
		return updatedEmployee;
	}
	
	public boolean deleteEmployee(Integer empNumber) {
		if (empRepository.exists(empNumber)) {
			empRepository.delete(empNumber);
			return true;
		} else {
			return false;
		}
		
	}
}
