package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="salaries")
public class Salaries {

	@EmbeddedId
    private SalariesPK id;
	
	@Column(name="salary")
	private Integer salary;
    
	@Column(name="to_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date toDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "empNumber", insertable=false, updatable=false)
	private Employee employee;

	public SalariesPK getId() {
		return id;
	}

	public void setId(SalariesPK id) {
		this.id = id;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}

