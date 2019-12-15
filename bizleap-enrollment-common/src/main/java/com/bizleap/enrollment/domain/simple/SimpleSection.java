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
	List<SimpleEmployee> simpleEmployeeList;
	List<SimpleStudent> simpleStudentList;

	private Date startTime;

	private Date endTime;

	private Date startDate;

	private Date endDate;

	public SimpleSection() {
		super();
	}

	public SimpleSection(List<SimpleEmployee> simpleEmployeeList, List<SimpleStudent> simpleStudentList, Date startTime,
			Date endTime, Date startDate, Date endDate) {
		super();
		this.simpleEmployeeList = simpleEmployeeList;
		this.simpleStudentList = simpleStudentList;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public List<SimpleEmployee> getSimpleEmployeeList() {
		return simpleEmployeeList;
	}

	public void setSimpleEmployeeList(List<SimpleEmployee> simpleEmployeeList) {
		this.simpleEmployeeList = simpleEmployeeList;
	}

	public List<SimpleStudent> getSimpleStudentList() {
		return simpleStudentList;
	}

	public void setSimpleStudentList(List<SimpleStudent> simpleStudentList) {
		this.simpleStudentList = simpleStudentList;
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
