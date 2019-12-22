package com.bizleap.enrollment.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.domain.utils.ConvensionUtils;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.resource.SectionServiceResource;
import com.bizleap.enrollment.service.SectionService;
@RestController
@RequestMapping(value= {"/sections"})
public class SectionServiceResourceImpl extends AbstractServiceResourceImpl implements SectionServiceResource{
    @Autowired
    SectionService sectionService;
    
    private final Logger logger=Logger.getLogger(SectionServiceResourceImpl.class);
    
    @RequestMapping(method=RequestMethod.GET,value="/list")
	public @ResponseBody  List<Section> getAllSection(HttpServletRequest request) throws ServiceUnavailableException {
		return sectionService.getAllSection();
	}
    
	@RequestMapping(method=RequestMethod.POST,value="/create")
	public @ResponseBody Boolean createSection(HttpServletRequest request,@RequestBody SimpleSection simpleSection) {
		if(simpleSection.equals(null)){
			logger.info("simpel section is null.");
		}
		else {
		logger.info("Create Section>>>>>>>>>>>>>>>>>>>>>"+simpleSection.toString());
		logger.info("Simple Section: "+simpleSection);
		try {
			logger.info("In the resource,before save.");
			sectionService.saveSection(ConvensionUtils.toSection(simpleSection));
			
		} catch(ServiceUnavailableException e) {
			logger.info("can't create section.");
			return false;
		}
		}
		return true;
    
	}

	@RequestMapping(method=RequestMethod.GET,value="/find/{boId}")
	public @ResponseBody Section findBySectionBoId(HttpServletRequest request,@PathVariable("boId") String boId)
			throws ServiceUnavailableException {
		logger.info("In resource .......");
		logger.info("BoId: " + boId);
		logger.info("Section: " + sectionService.findBySectionBoId(boId));
		return sectionService.findBySectionBoIdSingle(boId);
	}

}

