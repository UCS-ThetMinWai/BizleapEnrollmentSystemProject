package com.bizleap.enrollment.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface EmployeeServiceResource {
	List<Employee> getAllEmployee(HttpServletRequest request) throws ServiceUnavailableException;
	// createSection(HttpServletRequest request,SimpleSection section);
    Employee findByEmployeeBoId(HttpServletRequest request,String boId)throws ServiceUnavailableException;
    Boolean authorize(HttpServletRequest request,String email,String password)throws ServiceUnavailableException;
}


