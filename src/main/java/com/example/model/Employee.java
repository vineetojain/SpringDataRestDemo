package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@Column(name="emp_no")
	private Integer empNumber;
    
	@Column(name="birth_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate;
    
	@Column(name="first_name")
	private String firstName;
    
	@Column(name="last_name")
	private String lastName;
    
	@Column(name="gender")
	private String gender;    
    
	@Column(name="hire_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date hireDate;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="employee")
	private List<DepartmentEmployee> deptEmployees;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
	private List<DepartmentManager> deptManagers;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="employee")
	private List<Salaries> salaries;
	
	public Employee() {
		
	}
	public Employee(Integer empNumber, Date birthDate, String firstName, String lastName, String gender,
			Date hireDate) {
		super();
		this.empNumber = empNumber;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
	}

	public Integer getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(Integer empNumber) {
		this.empNumber = empNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public List<DepartmentEmployee> getDeptEmployees() {
		return deptEmployees;
	}
	public void setDeptEmployees(List<DepartmentEmployee> deptEmployees) {
		this.deptEmployees = deptEmployees;
	}
	public List<DepartmentManager> getDeptManagers() {
		return deptManagers;
	}
	public void setDeptManagers(List<DepartmentManager> deptManagers) {
		this.deptManagers = deptManagers;
	}
	public List<Salaries> getSalaries() {
		return salaries;
	}
	public void setSalaries(List<Salaries> salaries) {
		this.salaries = salaries;
	}
}
