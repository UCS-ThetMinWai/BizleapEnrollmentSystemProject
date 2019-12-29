package com.bizleap.enrollment.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "batch")
public class Batch extends AbstractEntity {
	
	@Temporal(TemporalType.DATE)
	@Column(name = "startDate")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "endDate")
	private Date endDate;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Section> sectionList;
	
	public Batch() {
		super();
	}
	
	public Batch(String boId) {
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
	
	public List<Section> getSectionList() {
		if(sectionList==null)
			sectionList=new ArrayList<Section>();
		return sectionList;
	}

	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.append("Start Date::", startDate)
				.append("End Date", endDate)
				.toString();
	}
}

