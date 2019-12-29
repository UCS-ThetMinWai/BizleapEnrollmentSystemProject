
package com.bizleap.enrollment.loader.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.StudentStatus;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.SectionService;
import com.bizleap.enrollment.service.StudentService;


public class StudentServiceImplTest extends ServiceTest {

	@Autowired
	StudentService studentService;
	
	@Autowired
	SectionService sectionService;
	
	private static Logger logger = Logger.getLogger(StudentServiceImplTest.class);

	@Ignore
	@Test
	public void testGetAllStudent() {
		try {
			System.out.print("starting test getAllStudent method..........");
			List<Student> studentList = studentService.getAllStudent();
			for(Student student : studentList) {
				System.out.println(student.getBoId()+ " " + student.getName() + " "  + student.getSection() + " " + student.getPaymentList() + " " + student.getStudentStatus() + " " + student.getDescription());
			}
		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}

	@Test
	public void testSaveStudent() throws ParseException {
		
		Student student = new Student();
		student.setBoId(SystemConstant.BOID_REQUIRED);
		student.setName("Thuzar");
		student.setAge(20);
		student.setAddress("Yangon");
		student.setPhoneNumber("122");
		student.setDescription("Hello student");
		student.setStudentStatus(StudentStatus.ENROLLED);
		student.setEmail("thuzar@gmail.com");
		student.setStudentStatus(StudentStatus.REGISTERED);
		try {
			logger.info("Save Student");
			Section section = sectionService.findBySectionBoIdSingle("SECTION00001");
			if (section == null)
				return;
			logger.info("Section found...........");
			logger.info("Section" + section.getBoId());
			student.setSection(section);
			section.getStudentList().add(student);
			studentService.saveStudent(student);
			logger.info("Saved Student Success");
		} catch (ServiceUnavailableException e) {
			logger.error("Error is:::" + e);
		}
	}

	@Ignore
	@Test
	public void testFindByStudentBoId() {
		try {
			System.out.println("starting testing testFindByStudentBoId method");
			List<Student> studentList = studentService.findByStudentBoId("STUDENT00001");
			for(Student student : studentList) {
	
				System.out.println(student.getBoId()+ " " + student.getName() + " " + student.getSection() + " " + student.getPaymentList() + " " + student.getStudentStatus() + " " + student.getDescription());
			}
		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}
	
	@Test
	public void testFindByStudentBoIdSingle() {
		try {
			System.out.println("starting testing testFindByStudentBoId method");
			Student student = studentService.findByStudentBoIdSingle("STUDENT00001");
			if(student!=null) {
				logger.info(student);
			}
		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}
}
