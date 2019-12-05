package com.bizleap.enrollment.service;

import com.bizleap.enrollment.domain.SystemConstant.EntityType;

public interface AbstractService {
	public long getCount();

	public String getNextBoId(EntityType entityType);

	public String makeBoId(String prefix, int currentObjCount);

	public String makeBoId(EntityType entityType, int currentObjectCount);
}
