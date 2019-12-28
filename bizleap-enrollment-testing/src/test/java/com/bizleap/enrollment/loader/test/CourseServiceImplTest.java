package com.bizleap.enrollment.loader.test;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.CourseService;

public class CourseServiceImplTest extends ServiceTest {

	@Autowired
	CourseService courseService;
	
	private static Logger logger = Logger.getLogger(CourseServiceImplTest.class);
	
	@Ignore
	@Test
	public void testGetAllCourse() {
		try {
			List<Course> courseList = courseService.getAllCourse();
			logger.info("Course Size: " + courseList.size());
			for(Course course : courseList) {
				logger.info("Course: " + course);
			}

		} catch (ServiceUnavailableException e) {
			logger.info("Error is:::" + e);
		}
	}
		
	//@Ignore
	@Test
	public void testSaveCourse() throws ParseException {
		
		Course course = new Course();
		course.setBoId(SystemConstant.BOID_REQUIRED);
		course.setName("Web Development");
		course.setFee(250000);
		try {
			courseService.saveCourse(course);
		} catch (ServiceUnavailableException e) {
			logger.error("Error is:::" + e);
		}
	}

	@Ignore
	@Test
	public void testFindByCourseBoId() {
		try {
			List<Course> courseList = courseService.findByCourseBoId("COURSE00001");
			for(Course course : courseList) {
	
				System.out.println(course.getBoId()+ " " + course.getName() + " " + course.getFee());
			}

		} catch (ServiceUnavailableException e) {
			logger.info("Error is:::" + e);

		}

	}
}
