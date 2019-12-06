package com.bizleap.enrollment.dao;

import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface BatchDao extends AbstractDao<Batch, String> {
	public void save(Batch batch) throws ServiceUnavailableException;
}
