
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

import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.simple.SimpleCourse;
import com.bizleap.enrollment.domain.utils.ConvensionUtils;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.resource.CourseServiceResource;
import com.bizleap.enrollment.service.CourseService;

@RestController
@RequestMapping(value= {"/courses"})
public class CourseServiceResourceImpl extends AbstractServiceResourceImpl implements CourseServiceResource{
    @Autowired
    CourseService courseService;
    
    private final Logger logger=Logger.getLogger(CourseServiceResourceImpl.class);
    
    @RequestMapping(method=RequestMethod.GET,value="/list")
	public @ResponseBody  List<Course> getAllCourse(HttpServletRequest request) throws ServiceUnavailableException {
		return courseService.getAllCourse();
	}

	@RequestMapping(method=RequestMethod.POST,value="/create")
	public @ResponseBody Boolean createCourse(HttpServletRequest request,@RequestBody SimpleCourse simpleCourse) {
		
		logger.info("Create Course>>>>>>>>>>>>>>>>>>>>>");
		try {
			courseService.saveCourse(ConvensionUtils.toCourse(simpleCourse));
			
		} catch(ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method=RequestMethod.GET,value="/find/{boId}")
	public @ResponseBody Course findByCourseBoId(HttpServletRequest request,@PathVariable String boId)
			throws ServiceUnavailableException {
		logger.info("In resource .......");
		return courseService.findByCourseBoIdSingle(boId);
	}

}


