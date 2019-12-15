package com.bizleap.enrollment.resource.impl.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.enrollment.rest.client.EmployeeServiceRestClient;
import com.bizleap.enrollment.rest.client.StudentServiceRestClient;

public class EmployeeServiceResourceTest {
	EmployeeServiceRestClient employeeServiceRestClient = new EmployeeServiceRestClient();
private static Logger logger = Logger.getLogger(EmployeeServiceResourceTest.class);

// @Ignore
// @Test
// public void testSaveStudent() {

// }

@Ignore
@Test
public void testFindByEmployeeBoId() {
	logger.info("Start ......");
	employeeServiceRestClient.findByEmployeeBoId("EMPLOYEE00002");
	logger.info("Success ......");
}

@Test
public void testGetAllEmployees() {
	logger.info("Start ......");
	employeeServiceRestClient.getAllEmployee();
	logger.info("Success ......");
}

}


