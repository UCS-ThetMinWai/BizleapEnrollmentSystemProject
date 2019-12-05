package com.bizleap.enrollment.loader.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.SectionService;


public class SectionServiceImplTest extends ServiceTest {

	@Autowired
	SectionService sectionService;
	
	private static Logger logger = Logger.getLogger(SectionServiceImplTest.class);

	@Ignore
	@Test
	public void testGetAllSection() {
		try {
			System.out.print("starting test getAllSection method..........");
			List<Section> sectionList = sectionService.getAllSection();
			for(Section section : sectionList) {
				System.out.println(section.getBoId()+ " " + section.getName() + " " + section.getStartDate() + " " + section.getEndDate() + " " +section.getEndTime() + " " + section.getEndDate() + " " + section.getEmployeeList() + " " + section.getCourse() + " " +section.getStudentList());//.get(0) + " " + section.getStudentList().get(1) + " " + section.getStudentList().get(2) + " " +section.getStudentList().get(3)); //+ " " + section.getStudentList().get(4) + " " + section.getStudentList().get(5));
			}
			//System.out.println("Section Lisst Size: " + sectionList);

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);

		}

	}
	
	
	@Test
	public void testFindByDepartmentBoId() {
		try {
			System.out.println("starting testing testFindByDepartmentBoId method");
			List<Section> sectionList = sectionService.findBySectionBoId("SECTION00001");
			for(Section section : sectionList) {
	
				System.out.println(section.getBoId()+ " " + section.getName() + " " + section.getStartDate() + " " + section.getEndDate() + " " +section.getEndTime() + " " + section.getEndDate() + " " + section.getEmployeeList() + " " + section.getCourse() + " " +section.getStudentList());//.get(0) + " " + section.getStudentList().get(1) + " " + section.getStudentList().get(2) + " " +section.getStudentList().get(3)); //+ " " + section.getStudentList().get(4) + " " + section.getStudentList().get(5));
			}

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);

		}

	}
}
