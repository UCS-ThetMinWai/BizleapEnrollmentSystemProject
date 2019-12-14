package com.bizleap.enrollment.loader.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.DayType;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.SectionService;


public class SectionServiceImplTest extends ServiceTest {

	@Autowired
	SectionService sectionService;
	
	private static Logger logger = Logger.getLogger(SectionServiceImplTest.class);

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
	
	
	@Ignore
	@Test
	public void testSaveSection() throws ParseException {
		
		Section section = new Section();
		section.setBoId(SystemConstant.BOID_REQUIRED);
		section.setName("SECTION_G");
		section.setDayType(DayType.SATURDAY);
		
		

		try {
			section.setStartDate( new SimpleDateFormat("yyyy-MM-dd").parse("2020-1-1"));
			section.setEndDate( new SimpleDateFormat("yyyy-MM-dd").parse("2020-3-1"));
			section.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("09:00:00"));
			section.setEndTime(new SimpleDateFormat("HH:mm:ss").parse("12:00:00"));
			sectionService.saveSection(section);
			System.out.println("saved success.....");
		} catch (ServiceUnavailableException e) {
			logger.error("Error is:" + e);
		}
	}

	@Ignore
	@Test
	public void testFindBySectionBoId() {
		try {
			System.out.println("starting testing testFindByDepartmentSectionBoId method");
			List<Section> sectionList = sectionService.findBySectionBoId("SECTION00001");
			for(Section section : sectionList) {
	
				System.out.println(section.getBoId()+ " " + section.getName() + " " + section.getStartDate() + " " + section.getEndDate() + " " +section.getEndTime() + " " + section.getEndDate() + " " + section.getEmployeeList() + " " + section.getCourse() + " " +section.getStudentList());//.get(0) + " " + section.getStudentList().get(1) + " " + section.getStudentList().get(2) + " " +section.getStudentList().get(3)); //+ " " + section.getStudentList().get(4) + " " + section.getStudentList().get(5));
			}

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);

		}

	}
}
