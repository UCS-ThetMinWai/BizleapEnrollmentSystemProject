package com.bizleap.enrollment.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.enrollment.domain.Section;
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

//	@RequestMapping(method=RequestMethod.POST,value="/create")
//	public @ResponseBody Boolean createSection(HttpServletRequest request,@RequestBody SimpleSection simpleSection) {
//		
//		logger.info("Create Section>>>>>>>>>>>>>>>>>>>>>");
//		try {
//			sectionService.saveSection(ConvensionUtils.toSection(simpleSection));
//			
//		} catch(ServiceUnavailableException e) {
//			return false;
//		}
//		return true;
//	}

	@RequestMapping(method=RequestMethod.GET,value="/find/{boId}")
	public @ResponseBody Section findBySectionBoId(HttpServletRequest request,@PathVariable String boId)
			throws ServiceUnavailableException {
		logger.info("In resource .......");
		return sectionService.findBySectionBoIdSingle(boId);
	}

}

