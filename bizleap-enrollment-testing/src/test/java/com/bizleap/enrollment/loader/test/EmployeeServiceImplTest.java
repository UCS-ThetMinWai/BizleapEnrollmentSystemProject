package com.bizleap.enrollment.loader.test;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.Position;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.EmployeeService;

public class EmployeeServiceImplTest extends ServiceTest {

	@Autowired
	EmployeeService employeeService;

	private static Logger logger = Logger.getLogger(EmployeeServiceImplTest.class);

	// @Ignore
	@Test
	public void testGetAllEmployee() {
		try {
			System.out.print("starting test getAllEmployee method..........");
			List<Employee> employeeList = employeeService.getAllEmployee();
			for (Employee employee : employeeList) {
				System.out.println(employee.getBoId() + " " + employee.getName() + " " + employee.getPosition() + " "
						+ employee.getSectionList() + " " + employee.getSalary());
			}
		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}

	@Ignore
	@Test
	public void testSaveEmployee() throws ParseException {

		Employee employee = new Employee();
		employee.setBoId(SystemConstant.BOID_REQUIRED);
		employee.setName("Daw Mya Mya");
		employee.setPosition(Position.ADMINISTRATOR);
		employee.setSalary(500000.0);
		try {
			employeeService.saveEmployee(employee);
		} catch (ServiceUnavailableException e) {
			logger.error("Error is:::" + e);
		}
	}

	@Ignore
	@Test
	public void testFindByEmployeeBoId() {
		try {
			System.out.println("starting testing testFindByEmployeeBoId method");
			List<Employee> employeeList = employeeService.findByEmployeeBoId("EMPLOYEE00001");
			for (Employee employee : employeeList) {

				System.out.println(employee.getBoId() + " " + employee.getName() + " " + employee.getPosition() + " "
						+ employee.getSectionList() + " " + employee.getSalary());
			}
		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}
}
