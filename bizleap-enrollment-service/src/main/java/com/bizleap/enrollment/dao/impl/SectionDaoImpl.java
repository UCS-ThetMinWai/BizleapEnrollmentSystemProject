package com.bizleap.enrollment.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.enrollment.dao.SectionDao;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

@Repository
public class SectionDaoImpl extends AbstractDaoImpl<Section, String> implements SectionDao {

	protected SectionDaoImpl() {
		super(Section.class);
	}

	@Override
	public void save(Section section) throws ServiceUnavailableException {
		saveOrUpdate(section);
	}
}
