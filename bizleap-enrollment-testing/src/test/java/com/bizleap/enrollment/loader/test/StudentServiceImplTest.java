package com.bizleap.enrollment.loader.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.StudentService;


public class StudentServiceImplTest extends ServiceTest {

	@Autowired
	StudentService studentService;
	
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
	
	//@Ignore
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
}
