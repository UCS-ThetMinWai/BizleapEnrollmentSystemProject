package com.bizleap.enrollment.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.exception.ServiceUnavailableException;


public interface SectionServiceResource {
	List<Section> getAllSection(HttpServletRequest request) throws ServiceUnavailableException;
	Boolean createSection(HttpServletRequest request,String input);
    Section findBySectionBoId(HttpServletRequest request,String boId)throws ServiceUnavailableException;
}

