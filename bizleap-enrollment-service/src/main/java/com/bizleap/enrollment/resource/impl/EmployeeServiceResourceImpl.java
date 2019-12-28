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

import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.simple.SimpleEmployee;
import com.bizleap.enrollment.domain.utils.ConvensionUtils;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.resource.EmployeeServiceResource;
import com.bizleap.enrollment.service.EmployeeService;

@RestController
@RequestMapping(value= {"/employees"})
public class EmployeeServiceResourceImpl extends AbstractServiceResourceImpl implements EmployeeServiceResource{
    @Autowired
    EmployeeService employeeService;
    
    private final Logger logger=Logger.getLogger(EmployeeServiceResourceImpl.class);
    
    @RequestMapping(method=RequestMethod.GET,value="/list")
	public @ResponseBody  List<Employee> getAllEmployee(HttpServletRequest request) throws ServiceUnavailableException {
		return employeeService.getAllEmployee();
	}
    
    

	@RequestMapping(method=RequestMethod.POST,value="/create")
	public @ResponseBody Boolean createStudent(HttpServletRequest request,@RequestBody SimpleEmployee simpleEmployee) {
				logger.info("Create Student>>>>>>>>>>>>>>>>>>>>>");
		try {
			employeeService.saveEmployee(ConvensionUtils.toEmployee(simpleEmployee));		
		} catch(ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method=RequestMethod.GET,value="/find/{boId}")
	public @ResponseBody Employee findByEmployeeBoId(HttpServletRequest request,@PathVariable String boId)
			throws ServiceUnavailableException {
		
		return employeeService.findByEmployeeBoIdSingle(boId);
	}

	@RequestMapping(method=RequestMethod.GET,value="/authorize/{email}/{password}")
	public @ResponseBody Boolean authorize(HttpServletRequest request,@PathVariable String email,@PathVariable String password)
			throws ServiceUnavailableException {
		return employeeService.authorize(email, password);
	}

}


