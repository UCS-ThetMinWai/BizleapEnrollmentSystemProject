package com.bizleap.enrollment.domain.simple;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.enrollment.domain.AbstractEntity;

public class SimpleCourse extends AbstractEntity{
	
	private double fee;

	public SimpleCourse() {
		super();
	}

	public SimpleCourse(String boId) {
		super(boId);
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
