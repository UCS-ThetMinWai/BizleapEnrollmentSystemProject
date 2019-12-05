package com.bizleap.enrollment.service;

import java.util.List;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface SectionService extends AbstractService {
	public List<Section> findBySectionBoId(String boId) throws ServiceUnavailableException;

	public Section findBySectionBoIdSingle(String boId) throws ServiceUnavailableException;

	public void saveSection(Section section) throws ServiceUnavailableException;

	public List<Section> getAllSection() throws ServiceUnavailableException;

}
