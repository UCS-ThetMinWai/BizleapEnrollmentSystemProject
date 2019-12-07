package com.bizleap.enrollment.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.enrollment.dao.BatchDao;
import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.BatchService;
import com.bizleap.enrollment.service.SectionService;

@Service("batchService")
public class BatchServiceImpl extends AbstractServiceImpl implements BatchService {
	
	@Autowired
	SectionService sectionService;
	
	@Autowired
	BatchDao batchDao;
	
	public void ensureBoIdDepartment(Batch batch) {
//		for(Section section : batch.getSectionList()) {
//			if(section.isBoIdRequired()) {
//				section.setBoId(sectionService.getNextBoId());
//			}
//		}
	}
	
	private void hibernateInitializeBatchList(List<Batch> batchList) {
		if(CollectionUtils.isEmpty(batchList))
			return;
		
		for(Batch batch : batchList) {
			hibernateInitializeBatch(batch);
		}
	}
	
	private void hibernateInitializeBatch(Batch batch) {
		if(batch == null)
			return;
		
		Hibernate.initialize(batch);
		
//		for(Section section : section.getSectionList()) {
//			Hibernate.initialize(section);
//		}
	}

	public List<Batch> findByBatchBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select department from Department department where department.boId=:dataInput";
		List<Batch> batchList=batchDao.findByString(queryStr, boId);	
		if(CollectionUtils.isEmpty(batchList)) 
			return null;
		hibernateInitializeBatchList(batchList);
		return batchList;
	}

	public Batch findByBatchBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Batch> batchList = findByBatchBoId(boId);
		if (!CollectionUtils.isEmpty(batchList)) {
			hibernateInitializeBatchList(batchList);
			if (batchList.size() > 0) {
				return batchList.get(0);
			}
		}
		return null;
	}

//	public void saveBatch(Batch batch) throws ServiceUnavailableException {
//		if(batch.isBoIdRequired()) {
//			batch.setBoId(getNextBoId());
//			ensureBoIdBatch(batch);
//		}
//		batchDao.save(batch);
//	}

	public List<Batch> getAllBatch() throws ServiceUnavailableException {
		List<Batch> batchList = batchDao.getAll("From Batch batch");
		if(CollectionUtils.isEmpty(batchList)) 
			return null;
		hibernateInitializeBatchList(batchList);
		return batchList;
	}

	@Override
	public long getCount() {
		return batchDao.getCount("select count(batch) from Batch batch");
	}



}
