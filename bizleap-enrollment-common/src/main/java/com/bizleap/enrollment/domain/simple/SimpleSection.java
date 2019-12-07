package com.bizleap.enrollment.domain.simple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.enrollment.domain.AbstractEntity;

public class SimpleSection extends AbstractEntity {
	// List<SimpleEmployee> employeeList;
	// List<SimpleStudent> studentList;

	private Date startTime;

	private Date endTime;

	private Date startDate;

	private Date endDate;

	public SimpleSection() {
		super();
	}

	public SimpleSection(String boId) {
		super(boId);
	}

	// public List<SimpleEmployee> getEmployeeList() {
	// return employeeList;
	// }
	//
	// public void setEmployeeList(List<SimpleEmployee> employeeList) {
	// this.employeeList = employeeList;
	// }
	//
	// public List<SimpleStudent> getStudentList() {
	// return studentList;
	// }
	//
	// public void setStudentList(List<SimpleStudent> studentList) {
	// this.studentList = studentList;
	// }

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).toString();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
