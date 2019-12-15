package com.bizleap.enrollment.loader.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.DayType;
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
			List<Section> sectionList = sectionService.getAllSection();
			logger.info("Section Size: " + sectionList.size());
			for(Section section : sectionList) {
				logger.info("Section: " + section);
			}

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}
	
	//@Test
	public void testFindByBoIdSingle() throws Exception{
		logger.info("Section: " + sectionService.findBySectionBoIdSingle("SECTION00001"));
	}
	
	//@Ignore
	@Test
	public void testSaveSection() throws ParseException {
		
		Section section = new Section();
		section.setBoId(SystemConstant.BOID_REQUIRED);
		section.setName("SECTION_G");
		section.setDayType(DayType.SATURDAY);
		
		Course course = new Course();
		course.setBoId(SystemConstant.BOID_REQUIRED);
		course.setName("PROJECT MANAGEMENT");
		course.setFee(400000.00);
		section.setCourse(course);
		
		Batch batch = new Batch();
		batch.setBoId(SystemConstant.BOID_REQUIRED);
		batch.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-1-1"));
		batch.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-1"));
		section.setBatch(batch);
		try {
			section.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-1-1"));
			section.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-3-1"));
			section.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("09:00:00"));
			section.setEndTime(new SimpleDateFormat("HH:mm:ss").parse("12:00:00"));
			
			sectionService.saveSection(section);
			logger.info("Save Success!!!!!!!!");
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
