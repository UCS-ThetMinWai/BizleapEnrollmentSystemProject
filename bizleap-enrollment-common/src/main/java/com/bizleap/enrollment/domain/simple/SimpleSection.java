package com.bizleap.enrollment.domain.simple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bizleap.enrollment.domain.AbstractEntity;
import com.bizleap.enrollment.domain.SystemConstant.DayType;

public class SimpleSection extends AbstractEntity {
	List<SimpleEmployee> simpleEmployeeList;
	List<SimpleStudent> simpleStudentList;
	SimpleCourse simpleCourse;
	public SimpleCourse getSimpleCourse() {
		return simpleCourse;
	}

	public void setSimpleCourse(SimpleCourse simpleCourse) {
		this.simpleCourse = simpleCourse;
	}

	private DayType dayType;
	
	private Date startTime;

	private Date endTime;

	public DayType getDayType() {
		return dayType;
	}

	public void setDayType(DayType dayType) {
		this.dayType = dayType;
	}

	private Date startDate;

	private Date endDate;

	public SimpleSection() {
		super();
	}

	public SimpleSection(List<SimpleEmployee> simpleEmployeeList, List<SimpleStudent> simpleStudentList, Date startTime,
			Date endTime, Date startDate, Date endDate,DayType dayType) {
		super();
		this.simpleEmployeeList = simpleEmployeeList;
		this.simpleStudentList = simpleStudentList;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dayType=dayType;
	}

	public List<SimpleEmployee> getSimpleEmployeeList() {
		if(simpleEmployeeList==null)
			simpleEmployeeList = new ArrayList<SimpleEmployee>();
		return simpleEmployeeList;
	}

	public void setSimpleEmployeeList(List<SimpleEmployee> simpleEmployeeList) {
		this.simpleEmployeeList = simpleEmployeeList;
	}

	public List<SimpleStudent> getSimpleStudentList() {
		if(simpleStudentList == null) 
			simpleStudentList = new ArrayList<SimpleStudent>();
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
