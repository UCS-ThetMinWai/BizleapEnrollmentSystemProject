package com.bizleap.enrollment.resource.impl.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.enrollment.rest.client.CourseServiceRestClient;

public class CourseServiceResourceImplTest {
	CourseServiceRestClient courseServiceRestClient = new CourseServiceRestClient();
	private static Logger logger = Logger.getLogger(CourseServiceResourceImplTest.class);

	// @Ignore
	// @Test
	// public void testSaveCourse() {

	// }
	
	@Ignore
	@Test
	public void testFindByCourseBoId() {
		logger.info("Start ......");
		courseServiceRestClient.findByCourseBoId("COURSE00002");
		logger.info("Success ......");
	}

	@Test
	public void testGetAllCourses() {
		logger.info("Start ......");
		courseServiceRestClient.getAllCourse();
		logger.info("Success ......");
	}

}
