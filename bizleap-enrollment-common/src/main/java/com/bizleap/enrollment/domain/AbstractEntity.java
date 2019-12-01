package com.bizleap.enrollment.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;

@MappedSuperclass
public class AbstractEntity {
	@Id
	@GeneratedValue
	private long id;

	private String boId;
	private String name;

	public AbstractEntity() {
	}

	public AbstractEntity(String boId) {
		this.boId = boId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBoId() {
		return boId;
	}

	public void setBoId(String boId) {
		this.boId = boId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean sameBoId(AbstractEntity entity) {
		if (entity == null)
			return false;
		if (getBoId() == null)
			return false;
		return (this.getBoId().equals(entity.getBoId()));
	}
//	public boolean isBoIdRequired() {
//		return boId==null || SystemConstant.BOID_REQUIRED.equals(getBoId());
//	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("boId", boId).append("name", name).toString();
	}
}

