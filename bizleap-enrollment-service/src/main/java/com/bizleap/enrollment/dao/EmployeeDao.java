package com.bizleap.enrollment.dao;

import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface EmployeeDao extends AbstractDao<Employee, String> {
	public void save(Employee employee) throws ServiceUnavailableException;

}
