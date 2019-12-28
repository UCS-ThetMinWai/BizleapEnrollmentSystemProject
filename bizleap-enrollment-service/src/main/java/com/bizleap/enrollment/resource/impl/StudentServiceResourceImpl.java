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

import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.simple.SimpleStudent;
import com.bizleap.enrollment.domain.utils.ConvensionUtils;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.resource.StudentServiceResource;
import com.bizleap.enrollment.service.StudentService;

@RestController
@RequestMapping(value= {"/students"})
public class StudentServiceResourceImpl extends AbstractServiceResourceImpl implements StudentServiceResource{
    @Autowired
    StudentService studentService;
    
    private final Logger logger=Logger.getLogger(StudentServiceResourceImpl.class);
    
    @RequestMapping(method=RequestMethod.GET,value="/list")
	public @ResponseBody  List<Student> getAllStudent(HttpServletRequest request) throws ServiceUnavailableException {
		return studentService.getAllStudent();
	}

	@RequestMapping(method=RequestMethod.POST,value="/create")
	public @ResponseBody Boolean createStudent(HttpServletRequest request,@RequestBody SimpleStudent simpleStudent) {
		
		logger.info("Create Student>>>>>>>>>>>>>>>>>>>>>");
		try {
			studentService.saveStudent(ConvensionUtils.toStudent(simpleStudent));
			
		} catch(ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method=RequestMethod.GET,value="/find/{boId}")
	public @ResponseBody Student findByStudentBoId(HttpServletRequest request,@PathVariable String boId)
			throws ServiceUnavailableException {
		logger.info("In resource .......");
		return studentService.findByStudentBoIdSingle(boId);
	}

}


