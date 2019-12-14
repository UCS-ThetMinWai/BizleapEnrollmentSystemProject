package com.bizleap.enrollment.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.enrollment.dao.EmployeeDao;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

@Repository
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee, String> implements EmployeeDao {

	protected EmployeeDaoImpl() {
		super(Employee.class);
	}

	@Override
	public void save(Employee employee) throws ServiceUnavailableException {
		saveOrUpdate(employee);
	}
}



