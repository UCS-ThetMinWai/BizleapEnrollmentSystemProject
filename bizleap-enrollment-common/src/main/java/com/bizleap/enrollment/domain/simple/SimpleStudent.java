package com.bizleap.enrollment.domain.simple;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import com.bizleap.enrollment.domain.Person;
import com.bizleap.enrollment.domain.SystemConstant.StudentStatus;

public class SimpleStudent extends Person{
	
	private String description;
	private SimpleSection simpleSection;
	private List<SimplePayment> paymentList;
	private StudentStatus studentStatus;
	
	public SimpleStudent() {
		super();
	}

	public SimpleStudent(String boId) {
		super(boId);
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SimpleSection getSimpleSection() {
		return simpleSection;
	}

	public void setSimpleSection(SimpleSection simpleSection) {
		this.simpleSection = simpleSection;
	}

	public List<SimplePayment> getPaymentList() {
		if(paymentList==null)
			paymentList = new ArrayList<SimplePayment>();
		return paymentList;
	}

	public void setPaymentList(List<SimplePayment> paymentList) {
		this.paymentList = paymentList;
	}

	public StudentStatus getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}

	@Override
	 public String toString() {
	 return new ToStringBuilder(this).appendSuper(super.toString())
	 .append("description",description).append("Section",simpleSection)
	 .append("paymentList",paymentList).append("studentStatus",studentStatus)
	 .toString();
	 }
}
