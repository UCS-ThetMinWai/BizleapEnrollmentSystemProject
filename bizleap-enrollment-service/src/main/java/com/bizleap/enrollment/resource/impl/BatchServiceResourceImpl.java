package com.bizleap.enrollment.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.domain.simple.SimpleBatch;
import com.bizleap.enrollment.domain.utils.ConvensionUtils;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.resource.BatchServiceResource;
import com.bizleap.enrollment.service.BatchService;

@RestController
@RequestMapping(value= {"/batchs"})
public class BatchServiceResourceImpl extends AbstractServiceResourceImpl implements BatchServiceResource {
	
	@Autowired
	private BatchService batchService;
	
	private final Logger logger=Logger.getLogger(BatchServiceResourceImpl.class);
    
    @RequestMapping(method=RequestMethod.GET,value="/list")
	public @ResponseBody  List<Batch> getAllBatch(HttpServletRequest request) throws ServiceUnavailableException {
		return batchService.getAllBatch();
	}

	@RequestMapping(method=RequestMethod.POST,value="/create")
	public @ResponseBody Boolean createBatch(HttpServletRequest request,@RequestBody SimpleBatch simpleBatch) {
		
		logger.info("Create Department>>>>>>>>>>>>>>>>>>>>>");
		try {
			batchService.saveBatch(ConvensionUtils.toBatch(simpleBatch));
			
		} catch(ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method=RequestMethod.GET,value="/find/{boId}")
	public @ResponseBody Batch findByBatchBoId(HttpServletRequest request,@PathVariable String boId)
			throws ServiceUnavailableException {
		logger.info("In resource .......");
		return batchService.findByBatchBoIdSingle(boId);
	}

}
