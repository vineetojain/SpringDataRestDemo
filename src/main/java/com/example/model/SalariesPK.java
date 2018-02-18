package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class SalariesPK implements Serializable{
	private static final long serialVersionUID = -6123396221531550737L;

	@Column(name="emp_no")
	private Integer empNumber;
	
	@Column(name="from_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fromDate;

	public Integer getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(Integer empNumber) {
		this.empNumber = empNumber;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
}
