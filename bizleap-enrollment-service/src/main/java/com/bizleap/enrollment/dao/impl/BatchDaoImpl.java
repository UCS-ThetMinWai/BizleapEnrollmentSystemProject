package com.bizleap.enrollment.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.enrollment.dao.BatchDao;
import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

@Repository
public class BatchDaoImpl extends AbstractDaoImpl<Batch, String> implements BatchDao {

	protected BatchDaoImpl() {
		super(Batch.class);
	}

	public void save(Batch batch) throws ServiceUnavailableException {
		saveOrUpdate(batch);
	}

	
}
