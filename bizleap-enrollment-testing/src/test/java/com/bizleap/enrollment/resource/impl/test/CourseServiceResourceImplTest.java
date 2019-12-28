package com.bizleap.enrollment.resource.impl.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.simple.SimpleCourse;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.rest.client.CourseServiceRestClient;

public class CourseServiceResourceImplTest {
	CourseServiceRestClient courseServiceRestClient = new CourseServiceRestClient();
	private static Logger logger = Logger.getLogger(CourseServiceResourceImplTest.class);

	 
	 @Test
	 public void testSaveCourse() {

		 SimpleCourse simpleCourse = new SimpleCourse();
		 simpleCourse.setBoId(SystemConstant.BOID_REQUIRED);
		 simpleCourse.setName("Mobile Development");
		 simpleCourse.setFee(200000.00);
		 //SimpleSection simpleSection =new SimpleSection();
		 courseServiceRestClient.saveCourse(simpleCourse);
	 }
	
	@Ignore
	@Test
	public void testFindByCourseBoId() {
		logger.info("Start ......");
		courseServiceRestClient.findByCourseBoId("COURSE00002");
		logger.info("Success ......");
	}

	@Ignore
	@Test
	public void testGetAllCourses() {
		logger.info("Start ......");
		courseServiceRestClient.getAllCourse();
		logger.info("Success ......");
	}

}
