package com.bizleap.enrollment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "payment")
public class Payment extends AbstractEntity {
	@Column(name = "fee")
	private double fee;

	@Column(name = "discount")
	private float discount;

	@Column(name = "discription")
	private String discription;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;

	public Payment() {

	}

	public Payment(String boId) {
		super(boId);
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("Fee ", fee).append("Discount ", discount)
				.append("Discription ", discription).toString();
	}
}
