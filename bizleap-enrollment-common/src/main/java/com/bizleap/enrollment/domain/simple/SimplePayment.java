package com.bizleap.enrollment.domain.simple;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.enrollment.domain.AbstractEntity;

public class SimplePayment extends AbstractEntity {
	private double fee;
	private float discount;
	private String discription;
	//private SimpleStudent student;
	
	public SimplePayment(String boId) {
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.append("Fee ", fee)
				.append("Discount ", discount)
				.append("Discription ", discription)
				.toString();
	}
}
