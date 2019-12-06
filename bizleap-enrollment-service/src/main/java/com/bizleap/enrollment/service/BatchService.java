package com.bizleap.enrollment.service;

import java.util.List;

import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.exception.ServiceUnavailableException;


public interface BatchService extends AbstractService {
	public List<Batch> findByBatchBoId(String boId)throws ServiceUnavailableException;
	public Batch findByBatchBoIdSingle(String boId)throws ServiceUnavailableException;
	public void saveBatch(Batch batch)throws ServiceUnavailableException;
	public List<Batch> getAllBatch()throws ServiceUnavailableException;
	
}
