
package com.bizleap.enrollment.resource.impl.test;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.StudentStatus;
import com.bizleap.enrollment.domain.simple.SimplePayment;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.domain.simple.SimpleStudent;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.loader.test.ServiceTest;
import com.bizleap.enrollment.rest.client.StudentServiceRestClient;
import com.bizleap.enrollment.service.SectionService;

public class StudentServiceResourceImplTest extends ServiceTest {
	StudentServiceRestClient studentServiceRestClient = new StudentServiceRestClient();
	private static Logger logger = Logger.getLogger(StudentServiceResourceImplTest.class);


	@Autowired
	SectionService sectionService;
	
	 @Test
	 public void testSaveStudent() throws ParseException, ServiceUnavailableException {
		 
		 logger.info("Start .......");
			
			SimpleStudent simpleStudent = new SimpleStudent();
			simpleStudent.setBoId(SystemConstant.BOID_REQUIRED);
			simpleStudent.setName("hlaing myar hta nae tae");
			simpleStudent.setAge(19);
			simpleStudent.setAddress("Pyin Oo Lwin");
			simpleStudent.setPhoneNumber("200");
			simpleStudent.setDescription("Hello student");
			simpleStudent.setStudentStatus(StudentStatus.ENROLLED);
			simpleStudent.setEmail("hlaingmyarhtanaetae@gmail.com");
			
			//simpleStudent.setSimpleSection(simpleSection);
			
			SimplePayment simplePayment = new SimplePayment();
			simplePayment.setBoId(SystemConstant.BOID_REQUIRED);
			simplePayment.setName("final Time Payment");
			simplePayment.setDiscount(0);
			simplePayment.setFee(200000.00);
			simplePayment.setDiscription("final Time Payment For student hlaing myar hta nae tae");
			simpleStudent.getPaymentList().add(simplePayment);			

			studentServiceRestClient.saveStudent(simpleStudent);
	 }
	
	@Ignore
	@Test
	public void testFindByStudentBoId() {
		logger.info("Start ......");
		studentServiceRestClient.findByStudentBoId("STUDENT00002");
		logger.info("Success ......");
	}

	@Ignore
	@Test
	public void testGetAllStudents() {
		logger.info("Start ......");
		studentServiceRestClient.getAllStudent();
		logger.info("Success ......");
	}

}

