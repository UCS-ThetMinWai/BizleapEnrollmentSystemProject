package com.bizleap.enrollment.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.enrollment.domain.SystemConstant.DayType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "section")
public class Section extends AbstractEntity {

	@Temporal(TemporalType.TIME)
	@Column(name = "starttime")
	private Date startTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "endtime")
	private Date endTime;

	@Temporal(TemporalType.DATE)
	@Column(name = "startdate")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "enddate")
	private Date endDate;

	// @JsonIgnore
	@JoinColumn(name = "course_id")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Course course;

	//@JsonIgnore
	@JsonBackReference
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "batchId")
	private Batch batch;

	//@JsonIgnore
	@ManyToMany(mappedBy = "sectionList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employee> employeeList;

	//@JsonIgnore
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> studentList;

	@Enumerated(EnumType.STRING)
	@Column(name = "days")
	private DayType dayType;

	public Section() {
		super();
	}

	public Section(Date startTime, Date endTime, Date startDate, Date endDate, Course course,
			List<Employee> employeeList, List<Student> studentList, DayType dayType) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.employeeList = employeeList;
		this.studentList = studentList;
		this.dayType = dayType;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public DayType getDayType() {
		return dayType;
	}

	public void setDayType(DayType dayType) {
		this.dayType = dayType;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("Start Time", startTime)
				.append("End Time", endTime).append("Start Date", startDate).append("End Date", endDate).toString();
	}

}
