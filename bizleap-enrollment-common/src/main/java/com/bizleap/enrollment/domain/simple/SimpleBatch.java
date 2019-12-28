package com.bizleap.enrollment.domain.simple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.enrollment.domain.AbstractEntity;

public class SimpleBatch extends AbstractEntity {
	
	private Date startDate;
	private Date endDate;

	List<SimpleSection> simpleSectionList;
	
	public SimpleBatch() {
		super();
	}
	
	public SimpleBatch(String boId) {
		super(boId);
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	 public List<SimpleSection> getSectionList() {
		     if(simpleSectionList == null) 
		    	 simpleSectionList = new ArrayList<SimpleSection>();
			 return simpleSectionList;
	 }
	
	public void setSimpleSectionList(List<SimpleSection> simpleSectionList) {
		this.simpleSectionList = simpleSectionList;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.append("Start Date::", startDate)
				.append("End Date", endDate)
				.toString();
	}
}
