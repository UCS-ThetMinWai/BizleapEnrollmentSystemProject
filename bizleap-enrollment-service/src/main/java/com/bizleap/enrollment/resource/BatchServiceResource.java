package com.bizleap.enrollment.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface BatchServiceResource {
	List<Batch> getAllBatch(HttpServletRequest request) throws ServiceUnavailableException;
	Boolean createBatch(HttpServletRequest request,SimpleBatch simpleBatch);
    Batch findByBatchBoId(HttpServletRequest request,String boId)throws ServiceUnavailableException;
}
