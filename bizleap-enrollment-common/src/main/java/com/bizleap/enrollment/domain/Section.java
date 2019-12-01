package com.bizleap.enrollment.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	// @OneToOne(cascade = CascadeType.ALL)
	// private Course course;

	// @ManyToMany(mappedBy = "sectionList")
	// private List<Employee> employeeList;
	//
	// @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch =
	// FetchType.LAZY)
	// private List<Student> studentList;

	@Enumerated(EnumType.STRING)
	@Column(name = "days")
	private DayType dayList;

	public Section() {
		super();
	}

	public Section(Date startTime, Date endTime, Date startDate, Date endDate) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.startDate = startDate;
		this.endDate = endDate;
		// this.dayList = dayList;
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
	//
	// public List<Date> getDayList() {
	// return dayList;
	// }
	//
	// public void setDayList(List<Date> dayList) {
	// this.dayList = dayList;
	// }

	// @Column(name= "status")
	// @Enumerated(EnumType.STRING)
	// private SectionStatus sectionStatus;

}
