package com.bizleap.enrollment.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bizleap.enrollment.dao.SectionDao;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.SystemConstant.EntityType;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.SectionService;

@Service("sectionService")
@Transactional(readOnly = true)
public class SectionServiceImpl extends AbstractServiceImpl implements SectionService {

	@Autowired
	SectionDao sectionDao;

	@Override
	public long getCount() {
		return sectionDao.getCount("select count(section) from Section section");
	}

	@Override
	public List<Section> findBySectionBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select section from Section section where section.boId=:dataInput";
		List<Section> sectionList = sectionDao.findByString(queryStr, boId);
		if (CollectionUtils.isEmpty(sectionList))
			return null;
		hibernateInitializeSectionList(sectionList);
		return sectionList;
	}

	@Override
	public Section findBySectionBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Section> sectionList = findBySectionBoId(boId);
		if (!CollectionUtils.isEmpty(sectionList)) {
			hibernateInitializeSectionList(sectionList);
			if (sectionList.size() > 0) {
				return sectionList.get(0);
			}
		}
		return null;
	}

	@Override
	public void saveSection(Section section) throws ServiceUnavailableException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Section> getAllSection() throws ServiceUnavailableException {
		List<Section> sectionList = sectionDao.getAll("From Section section");
		if (CollectionUtils.isEmpty(sectionList))
			return null;
		hibernateInitializeSectionList(sectionList);
		return sectionList;
	}

	private String getNextBoId() {
		return getNextBoId(EntityType.SECTION);
	}

	private void hibernateInitializeSectionList(List<Section> sectionList) {
		Hibernate.initialize(sectionList);
		if (CollectionUtils.isEmpty(sectionList))
			return;

		for (Section section : sectionList) {
			hibernateInitializeSection(section);
		}
	}

	private void hibernateInitializeSection(Section section) {
		Hibernate.initialize(section);
		if (section == null)
			return;

		Hibernate.initialize(section);

		for (Employee employee : section.getEmployeeList()) {
			Hibernate.initialize(employee);
		}

		for (Student student : section.getStudentList()) {
			Hibernate.initialize(student);
		}
		Hibernate.initialize(section.getCourse());
		Hibernate.initialize(section.getBatch());
	}

}
