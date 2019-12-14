package com.bizleap.enrollment.domain.simple;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.enrollment.domain.AbstractEntity;
import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.SystemConstant.StudentStatus;

public class SimpleStudent extends AbstractEntity{
	
	private String description;
	private Section section;
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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<SimplePayment> getPaymentList() {
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
	 .append("description",description).append("Section",section)
	 .append("paymentList",paymentList).append("studentStatus",studentStatus)
	 .toString();
	 }
}
