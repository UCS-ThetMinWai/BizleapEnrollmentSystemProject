package com.bizleap.enrollment.resource.impl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.enrollement.util.Parser;
import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.SystemConstant.DayType;
import com.bizleap.enrollment.domain.simple.SimpleCourse;
import com.bizleap.enrollment.domain.simple.SimpleEmployee;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.domain.utils.ConvensionUtils;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.resource.SectionServiceResource;
import com.bizleap.enrollment.service.CourseService;
import com.bizleap.enrollment.service.EmployeeService;
import com.bizleap.enrollment.service.SectionService;
@RestController
@RequestMapping(value= {"/sections"})
public class SectionServiceResourceImpl extends AbstractServiceResourceImpl implements SectionServiceResource{
    @Autowired
    SectionService sectionService;
    
    @Autowired
    CourseService courseService;
    @Autowired
    EmployeeService employeeService;
    
    private final Logger logger=Logger.getLogger(SectionServiceResourceImpl.class);
    
    @RequestMapping(method=RequestMethod.GET,value="/list")
	public @ResponseBody  List<Section> getAllSection(HttpServletRequest request) throws ServiceUnavailableException {
		return sectionService.getAllSection();
	}
    
	@RequestMapping(method=RequestMethod.POST,value="/create")
	public @ResponseBody Boolean createSection(HttpServletRequest request,@RequestParam("input") String input) {
		JSONObject json = Parser.parseJSon(input);
		SimpleSection simpleSection = new SimpleSection();
		simpleSection.setName((String) json.get("name"));
		simpleSection.setDayType(DayType.valueOf((String)json.get("dayType")));
//		simpleSection.setStartDate(Date.valueOf((String) json.get("startDate")));
//		simpleSection.setStartDate(Date.valueOf((String) json.get("endDate")));
//		simpleSection.setStartTime(Date.valueOf((String) json.get("startTime")));
//		simpleSection.setStartTime(Date.valueOf((String) json.get("endTime")));
		String courseBoId = (String) json.get("courseBoId");
		String employeeBoId = (String) json.get("employeeBoId");

		if(simpleSection.equals(null)){
			logger.info("simpel section is null.");
		}
		else {
		logger.info("Create Section>>>>>>>>>>>>>>>>>>>>>"+simpleSection.toString());
		logger.info("Simple Section: "+simpleSection);
		try {
			Employee employee = employeeService.findByEmployeeBoIdSingle(employeeBoId);
//			SimpleEmployee simpleEmployee = new SimpleEmployee();
//			simpleEmployee.setName(employee.getName());
//			simpleEmployee.setAddress(employee.getAddress());
//			simpleEmployee.setEmail(employee.getEmail());
//			simpleEmployee.setPassword(employee.getPassword());
//			simpleEmployee.setPhoneNumber(employee.getPassword());
//			simpleEmployee.setPosition(employee.getPosition());
//			simpleEmployee.setSalary(employee.getSalary());
			
			Course course = courseService.findByCourseBoIdSingle(courseBoId);
			SimpleCourse simpleCourse = new SimpleCourse();
			simpleCourse.setName(course.getName());
			simpleCourse.setFee(course.getFee());
			//simpleSection.getSimpleEmployeeList().add(simpleEmployee);
			simpleSection.setSimpleCourse(simpleCourse);
			logger.info("In the resource,before save.");
			Section section =ConvensionUtils.toSection(simpleSection);
			section.getEmployeeList().add(employee);
			employee.getSectionList().add((section));
			sectionService.saveSection(section);
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

