package com.bizleap.enrollment.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bizleap.enrollment.dao.EmployeeDao;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.SystemConstant.EntityType;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.EmployeeService;
import com.bizleap.enrollment.service.SectionService;
import com.bizleap.enrollment.service.StudentService;

@Service("employeeService")
@Transactional(readOnly = true)
public class EmployeeServiceImpl extends AbstractServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	SectionService sectionService;
	private static final Logger logger = Logger.getLogger(SectionServiceImpl.class);
	public void ensureBoIdEmployee(Employee employee) {

		if (!CollectionUtils.isEmpty(employee.getSectionList())) {
			for (Section section : employee.getSectionList()) {
				if (section.isBoIdRequired()) {
					section.setBoId(sectionService.getNextBoId(EntityType.SECTION));
				}
			}
		}
	}
	
	@Override
	public List<Employee> findByEmployeeBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select employee from Employee employee where employee.boId=:dataInput";
		List<Employee> employeeList = employeeDao.findByString(queryStr, boId);
		if (CollectionUtils.isEmpty(employeeList))
			return null;
		hibernateInitializeEmployeeList(employeeList);
		return employeeList;
	}

	@Override
	public Employee findByEmployeeBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Employee> employeeList = findByEmployeeBoId(boId);
		if (!CollectionUtils.isEmpty(employeeList)) {
			hibernateInitializeEmployeeList(employeeList);
			if (employeeList.size() > 0) {
				return employeeList.get(0);
			}
		}
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) throws ServiceUnavailableException {
		logger.info("Employee" + employee);
		if (employee.isBoIdRequired()) {
			employee.setBoId(getNextBoId());
			ensureBoIdEmployee(employee);
		}
		employeeDao.save(employee);
	}



	@Override
	public List<Employee> getAllEmployee() throws ServiceUnavailableException {
		List<Employee> employeeList = employeeDao.getAll("From Employee employee");
		if (CollectionUtils.isEmpty(employeeList))
			return null;
		hibernateInitializeEmployeeList(employeeList);
		return employeeList;
	}

	private String getNextBoId() {
		return getNextBoId(EntityType.STUDENT);
	}

	@Override
	public long getCount() {
		return employeeDao.getCount("select count(employee) from Employee employee");
	}

	@Override
	public void hibernateInitializeEmployeeList(List<Employee> employeeList) {
		Hibernate.initialize(employeeList);
		if (CollectionUtils.isEmpty(employeeList))
			return;

		for (Employee employee : employeeList) {
			hibernateInitializeEmployee(employee);
		}

	}

	@Override
	public void hibernateInitializeEmployee(Employee employee) {
		Hibernate.initialize(employee);
		if (employee == null)
			return;

		Hibernate.initialize(employee);

		for (Section section : employee.getSectionList()) {
			Hibernate.initialize(section);
		}
	}
}