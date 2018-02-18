package com.example.demo;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController

public class EmployeeController implements ApplicationContextAware{

	ApplicationContext context;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello from Spring Boot Rest Demo App ";
	}

	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public void addEmployee(@RequestBody Employee emp) {
		employeeService.save(emp);
	}
	
	/*@RequestMapping("/employee/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable Integer id) {
		try {
			Employee empl = employeeService.findOne(id);
			return new ResponseEntity<Employee>(empl, HttpStatus.OK);
		} catch(EmployeeNotFoundException e) {
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
	}*/
	
	@RequestMapping("/employee/{id}")
	public Employee findEmployee(@PathVariable Integer id) {
		Employee empl = employeeService.findOne(id);
		return empl; 
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employees")
	public List<Employee> findAllEmployee() {
		context.getEnvironment();
		return employeeService.findAllEmployees();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employee/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		if (!employeeService.deleteEmployee(id)) {
			
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employee/{id}")
	public Employee updateEmployee(@PathVariable Integer id, 
			@RequestBody Employee emp) {
		Employee updatedEmployee = employeeService.updateEmployee(id, emp);
		return null != updatedEmployee ? updatedEmployee : null;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	/*@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public @ResponseBody ErrorInfo handleEmployeeNotFoundException
			(HttpServletRequest req, EmployeeNotFoundException ex) {
		System.out.println("Inside Controller Exception Handler");
		System.out.println(req.getRequestURI() + " : " + ex.getMessage());
		return new ErrorInfo(req.getRequestURI(), ex.getMessage());
	}*/
}
