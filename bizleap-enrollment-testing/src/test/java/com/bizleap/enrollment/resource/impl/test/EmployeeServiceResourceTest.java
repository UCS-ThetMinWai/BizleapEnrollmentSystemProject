package com.bizleap.enrollment.resource.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.DayType;
import com.bizleap.enrollment.domain.SystemConstant.Position;
import com.bizleap.enrollment.domain.simple.SimpleEmployee;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.rest.client.EmployeeServiceRestClient;

public class EmployeeServiceResourceTest {
	EmployeeServiceRestClient employeeServiceRestClient = new EmployeeServiceRestClient();
	private static Logger logger = Logger.getLogger(EmployeeServiceResourceTest.class);

	@Test
	public void testSaveSection() throws ParseException {

		logger.info("Start .......");
		SimpleSection simpleSection = new SimpleSection();
		simpleSection.setBoId(SystemConstant.BOID_REQUIRED);
		simpleSection.setName("SECTION_R");
		simpleSection.setDayType(DayType.MONDAY);
		simpleSection.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-1-1"));
		simpleSection.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-3-1"));
		simpleSection.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("09:00:00"));
		simpleSection.setEndTime(new SimpleDateFormat("HH:mm:ss").parse("12:00:00"));

		SimpleEmployee simpleEmployee = new SimpleEmployee();
		simpleEmployee.setBoId(SystemConstant.BOID_REQUIRED);
		simpleEmployee.setName("Daw May Mee");
		simpleEmployee.setPosition(Position.INSTRUCTOR);
		simpleEmployee.setSalary(800000.0);
		simpleEmployee.setAddress("Mandalay");
		simpleEmployee.setEmail("dawmaymee@gmail.com");
		simpleEmployee.setPassword("dawmaymee");
		simpleEmployee.setPhoneNumber("199");
		simpleEmployee.setAge(45);
		simpleEmployee.getSimpleSectionList().add(simpleSection);
		employeeServiceRestClient.saveEmployee(simpleEmployee);
	}

	@Ignore
	@Test
	public void testFindByEmployeeBoId() {
		logger.info("Start ......");
		employeeServiceRestClient.findByEmployeeBoId("EMPLOYEE00002");
		logger.info("Success ......");
	}

	@Ignore
	@Test
	public void testGetAllEmployees() {
		logger.info("Start ......");
		employeeServiceRestClient.getAllEmployee();
		logger.info("Success ......");
	}

}
