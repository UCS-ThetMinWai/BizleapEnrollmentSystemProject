package com.bizleap.enrollment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="course")
public class Course extends AbstractEntity{
  
	@Column(name="fee")
	private double fee;

	public Course() {
		super();
	}
	
	public Course(String boId) {
		super();
	}
	
	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
				.append("fee",fee)
				.toString();	
		}
}
