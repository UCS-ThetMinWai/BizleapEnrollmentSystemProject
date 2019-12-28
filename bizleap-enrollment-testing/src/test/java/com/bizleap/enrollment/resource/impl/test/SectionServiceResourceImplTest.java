package com.bizleap.enrollment.resource.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.DayType;
import com.bizleap.enrollment.domain.SystemConstant.Position;
import com.bizleap.enrollment.domain.SystemConstant.StudentStatus;
import com.bizleap.enrollment.domain.simple.SimpleCourse;
import com.bizleap.enrollment.domain.simple.SimpleEmployee;
import com.bizleap.enrollment.domain.simple.SimplePayment;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.domain.simple.SimpleStudent;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.loader.test.ServiceTest;
import com.bizleap.enrollment.rest.client.SectionServiceRestClient;
import com.bizleap.enrollment.service.CourseService;

public class SectionServiceResourceImplTest extends ServiceTest{
	SectionServiceRestClient sectionServiceRestClient = new SectionServiceRestClient();
	private static Logger logger = Logger.getLogger(SectionServiceResourceImplTest.class);

	@Autowired
	CourseService courseService;
	// @Ignore
	 @Test
	 public void testSaveSection() throws ParseException, ServiceUnavailableException {
		 
		 logger.info("Start .......");
			SimpleSection simpleSection = new SimpleSection();
			simpleSection.setBoId(SystemConstant.BOID_REQUIRED);
			simpleSection.setName("SECTION_X");
			simpleSection.setDayType(DayType.SATURDAY);
			simpleSection.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-1-1"));
			simpleSection.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-3-1"));
			simpleSection.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("09:00:00"));
			simpleSection.setEndTime(new SimpleDateFormat("HH:mm:ss").parse("12:00:00"));
			
			
			
			SimpleEmployee simpleEmployee = new SimpleEmployee();
			simpleEmployee.setBoId(SystemConstant.BOID_REQUIRED);
			simpleEmployee.setName("Daw Mya Mya");
			simpleEmployee.setPosition(Position.ADMINISTRATOR);
			simpleEmployee.setSalary(500000.0);
			simpleEmployee.setAddress("Yangon");
			simpleEmployee.setEmail("myamya@gmail.com");
			simpleEmployee.setPassword("dawmyamya");
			simpleEmployee.setPhoneNumber("199");
			simpleEmployee.setAge(45);
			simpleSection.getSimpleEmployeeList().add(simpleEmployee);			
			
			SimpleStudent simpleStudent = new SimpleStudent();
			simpleStudent.setBoId(SystemConstant.BOID_REQUIRED);
			simpleStudent.setName("May Thawdar");
			simpleStudent.setAge(20);
			simpleStudent.setAddress("Bagan");
			simpleStudent.setPhoneNumber("1245");
			simpleStudent.setDescription("Hello student");
			simpleStudent.setStudentStatus(StudentStatus.ENROLLED);
			simpleStudent.setEmail("maythawdar@gmail.com");
			simpleStudent.setStudentStatus(StudentStatus.REGISTERED);
						
			SimplePayment simplePayment = new SimplePayment();
			simplePayment.setBoId(SystemConstant.BOID_REQUIRED);
			simplePayment.setName("Final Payment");
			simplePayment.setDiscount(0);
			simplePayment.setFee(100000.00);
			simplePayment.setDiscription("Final  Payment For student May Thardar");
			simpleStudent.getPaymentList().add(simplePayment);
			simpleSection.getSimpleStudentList().add(simpleStudent);
			
			Course course = courseService.findByCourseBoIdSingle("COURSE00013");
			logger.info("Course find "+course);
			SimpleCourse simpleCourse = new SimpleCourse();
			simpleCourse.setId(course.getId());
			simpleCourse.setName(course.getName());
			simpleCourse.setBoId(course.getBoId());
			simpleCourse.setFee(course.getFee());
			simpleSection.setSimpleCourse(simpleCourse);
			sectionServiceRestClient.saveSection(simpleSection);
	 }
	@Ignore
	@Test
	public void testFindBySectionBoId() {
		logger.info("Start ......");
		sectionServiceRestClient.findBySectionBoId("SECTION00002");
		logger.info("Success ......");
	}

	@Ignore
	@Test
	public void testGetAllSections() {
		logger.info("Start ......");
		sectionServiceRestClient.getAllSection();
		logger.info("Success ......");
	}

}
