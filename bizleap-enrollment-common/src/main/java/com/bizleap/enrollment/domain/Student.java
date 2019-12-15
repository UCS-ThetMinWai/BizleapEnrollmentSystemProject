package com.bizleap.enrollment.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.enrollment.domain.SystemConstant.StudentStatus;
import com.bizleap.enrollment.domain.simple.SimplePayment;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student extends Person {

	@Column(name = "description")
	private String description;

	@JsonIgnore
	@JoinColumn(name = "sectionId")
	@ManyToOne
	private Section section;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Payment> paymentList;

	@Column(name = "enrollType")
	@Enumerated(EnumType.STRING)
	private StudentStatus studentStatus;

	public Student() {
		super();
	}

	public Student(String boId) {
		super();
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

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
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
		return new ToStringBuilder(this).appendSuper(super.toString()).append("description", description)
				.append("Section", section).append("paymentList", paymentList).append("studentStatus", studentStatus)
				.toString();
	}

}
