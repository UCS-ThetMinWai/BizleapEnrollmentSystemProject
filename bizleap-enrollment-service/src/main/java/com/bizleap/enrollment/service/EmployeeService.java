package com.bizleap.enrollment.service;

import java.util.List;

import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface EmployeeService extends AbstractService {
	public List<Employee> findByEmployeeBoId(String boId) throws ServiceUnavailableException;

	public Employee findByEmployeeBoIdSingle(String boId) throws ServiceUnavailableException;
	public void saveEmployee(Employee employee) throws ServiceUnavailableException;

	public List<Employee> getAllEmployee() throws ServiceUnavailableException;
	public void hibernateInitializeEmployeeList(List<Employee> employeeList);
	public void hibernateInitializeEmployee(Employee employee);

}
