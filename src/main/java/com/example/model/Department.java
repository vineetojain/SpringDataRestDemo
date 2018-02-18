package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
    
	@Id
	@Column(name="dept_no")
	private String deptNumber;
    
	@Column(name="dept_name")
	private String deptName;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
	private List<DepartmentEmployee> deptEmployees;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
	private List<DepartmentManager> deptManagers;

	public String getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

}
