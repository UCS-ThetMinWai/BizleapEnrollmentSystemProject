package com.bizleap.enrollment.dao;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface SectionDao extends AbstractDao<Section, String> {
	public void save(Section department) throws ServiceUnavailableException;
}