package com.bizleap.enrollment.resource.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.simple.SimpleBatch;
import com.bizleap.enrollment.domain.simple.SimpleEmployee;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.domain.simple.SimpleStudent;
import com.bizleap.enrollment.rest.client.SectionServiceRestClient;

public class SectionServiceResourceImplTest {
	SectionServiceRestClient sectionServiceRestClient = new SectionServiceRestClient();
	private static Logger logger = Logger.getLogger(SectionServiceResourceImplTest.class);

	// @Ignore
	 @Test
	 public void testSaveSection() {
		 
		 logger.info("Start .......");
			SimpleSection simpleSection = new SimpleSection();
			simpleSection.setBoId(SystemConstant.BOID_REQUIRED);
			simpleSection.setName("SECTION_I");
			SimpleEmployee simpleEmployee = new SimpleEmployee();
			simpleEmployee.setBoId(SystemConstant.BOID_REQUIRED);
			simpleEmployee.setName("Daw Khin Khin");
			List<SimpleEmployee> simpleEmployeeList = new ArrayList<SimpleEmployee>();
			simpleEmployeeList.add(simpleEmployee);
			simpleSection.setSimpleEmployeeList(simpleEmployeeList);
			SimpleStudent simpleStudent = new SimpleStudent();
			simpleStudent.setBoId(SystemConstant.BOID_REQUIRED);
			simpleStudent.setName("Daw Hla");
			List<SimpleStudent> simpleStudentList = new ArrayList<SimpleStudent>();
			simpleStudentList.add(simpleStudent);
			SimpleBatch simpleBatch = new SimpleBatch();
			simpleBatch.setBoId(SystemConstant.BOID_REQUIRED);
			simpleBatch.setName("BATCH HIPER");
			simpleSection.setSimpleStudentList(simpleStudentList);
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
