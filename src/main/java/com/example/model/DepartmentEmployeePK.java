package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DepartmentEmployeePK implements Serializable{

	private static final long serialVersionUID = -8173099298367362959L;

	@Column(name="emp_no")
	private Integer empNumber;
	
	@Column(name="dept_no")
	private String deptNumber;

	public DepartmentEmployeePK() {
	}
	
	public Integer getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(Integer empNumber) {
		this.empNumber = empNumber;
	}

	public String getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}
}
