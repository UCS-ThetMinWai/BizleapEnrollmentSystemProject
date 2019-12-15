package com.bizleap.enrollment.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface EmployeeServiceResource {
	List<Employee> getAllEmployee(HttpServletRequest request) throws ServiceUnavailableException;
	// createSection(HttpServletRequest request,SimpleSection section);
    Employee findByEmployeeBoId(HttpServletRequest request,String boId)throws ServiceUnavailableException;
}


