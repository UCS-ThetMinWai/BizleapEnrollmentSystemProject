package com.bizleap.enrollment.domain.simple;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.enrollment.domain.Person;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.SystemConstant.Position;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SimpleEmployee extends Person  {
	private Double salary;
	private Position position;
	private List<SimpleSection> simpleSectionList;
	
	public SimpleEmployee() {
	}

	public SimpleEmployee(String boId) {
		super(boId);
	}
	public List<SimpleSection> getSimpleSectionList() {
		
		return simpleSectionList;
	}

	public void setSimpleSessionList(List<SimpleSection> simpleSectionList) {
		this.simpleSectionList=simpleSectionList;
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



