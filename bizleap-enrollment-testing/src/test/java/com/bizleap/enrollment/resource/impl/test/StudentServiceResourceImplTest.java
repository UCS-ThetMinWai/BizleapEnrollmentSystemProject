package com.bizleap.enrollment.resource.impl.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.enrollment.rest.client.StudentServiceRestClient;

public class StudentServiceResourceImplTest {
	StudentServiceRestClient studentServiceRestClient = new StudentServiceRestClient();
	private static Logger logger = Logger.getLogger(StudentServiceResourceImplTest.class);

	// @Ignore
	// @Test
	// public void testSaveStudent() {

	// }
	
	@Ignore
	@Test
	public void testFindByStudentBoId() {
		logger.info("Start ......");
		studentServiceRestClient.findByStudentBoId("STUDENT00002");
		logger.info("Success ......");
	}

	@Test
	public void testGetAllStudents() {
		logger.info("Start ......");
		studentServiceRestClient.getAllStudent();
		logger.info("Success ......");
	}

}

