package com.bizleap.enrollment.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "batch")
public class Batch extends AbstractEntity {
	@Column(name = "startDate")
	Date startDate;
	
	@Column(name = "endDate")
	Date endDate;

	@OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Payment> paymentList;
	
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
	
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.append("Start Date::", startDate)
				.append("End Date", endDate)
				.toString();
	}
}

