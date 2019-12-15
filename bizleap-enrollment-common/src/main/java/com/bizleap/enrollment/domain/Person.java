package com.bizleap.enrollment.domain;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;

@MappedSuperclass
public class Person extends AbstractEntity{

	private String address;
	private int age;
	private String email;
	private String phoneNumber;
	
	 public Person() {
	    	
	    }
	    
	    public Person(String boId) {
	    	super(boId);
	    	
	    }
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	

	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
				.append("email",email)
				.append("phoneNumber",phoneNumber)
				.append("age",age)
				.append("address",address)
				.append("phoneNumber",phoneNumber).toString();
	}
	

}
