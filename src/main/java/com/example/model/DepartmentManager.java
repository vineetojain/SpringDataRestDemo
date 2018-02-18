package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="dept_manager")
public class DepartmentManager {
	
	@EmbeddedId
	private DepartmentManagerPK id;
	
	@Column(name="from_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fromDate;
	
	@Column(name="to_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date toDate;
	
	@ManyToOne
	@JoinColumn(name = "deptNumber", insertable=false, updatable=false) 
	private Department department;
	
	@OneToOne
	@JoinColumn(name = "empNumber", insertable=false, updatable=false) 
	private Employee employee;

	public DepartmentManagerPK getId() {
		return id;
	}

	public void setId(DepartmentManagerPK id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
