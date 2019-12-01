package com.bizleap.enrollment.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Employee")
public class Employee extends Person {

	@Column(name = "salary")
	private Double salary;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Employee_Section", joinColumns = { @JoinColumn(name = "section_id") }, inverseJoinColumns = {
			@JoinColumn(name = "employee_id") })
	private List<Section> sectionList;

	@Enumerated(EnumType.STRING)
	private Position position;

	public Employee() {

	}

	public Employee(String boId) {
		super(boId);
	}
	public List<Section> getSectionList() {

		if (sectionList=null)
			this.sectionList<Section>();
		
		return sectionList;
	}

	public void setSessionList(List<Section> sectionList) {
		this.sectionList=sectionList;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}



	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("Salary", salary)
				.toString();
	}

}
